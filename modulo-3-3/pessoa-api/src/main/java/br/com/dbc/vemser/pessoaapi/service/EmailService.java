package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.EnderecoEntity;
import br.com.dbc.vemser.pessoaapi.entity.PessoaEntity;
import br.com.dbc.vemser.pessoaapi.exceptions.RegraDeNegocioException;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.util.ResourceUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class EmailService {

    private final Configuration fmConfiguration;

    @Value("${spring.mail.username}")
    private String from;

    private static final String TO = "bruno.dias@dbccompany.com.br";

    private final JavaMailSender emailSender;

    public void sendSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(TO);
        message.setSubject("E-mail Simples");
        message.setText("Teste \n minha mensagem \n\nAtt,\nSistema.");
        emailSender.send(message);
    }

    public void sendWithAttachment() throws MessagingException, FileNotFoundException {
        MimeMessage message = emailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(message,
                true);

        helper.setFrom(from);
        helper.setTo(TO);
        helper.setSubject("E-mail com Anexo");
        helper.setText("Teste\n minha mensagem \n\nAtt,\nSistema.");

        File file1 = ResourceUtils.getFile("classpath:imagem.jpg");
        //File file1 = new File("imagem.jpg");
        FileSystemResource file
                = new FileSystemResource(file1);
        helper.addAttachment(file1.getName(), file);

        emailSender.send(message);
    }

    public void sendEmail(PessoaEntity pessoa, int acao) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("E-mail Template");
            mimeMessageHelper.setText(getPessoaTemplate(pessoa, acao), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void sendEmail(PessoaEntity pessoa, EnderecoEntity endereco, int acao) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(pessoa.getEmail());
            mimeMessageHelper.setSubject("E-mail Template");
            mimeMessageHelper.setText(getEnderecoTemplate(pessoa, endereco, acao), true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String getContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Pessoal do sistema");

        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getPessoaTemplate(PessoaEntity pessoa, int acao) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        String texto = "";
        switch(acao) {
            case 1 -> {
                texto = "Estamos felizes em ter você em nosso sistema :)\n Seu cadastro foi realizado com sucesso seu identificador é " + pessoa.getIdPessoa();
            }
            case 2 -> {
                texto = "Seus dados foram atualizados no nosso sistema";
            }
            case 3 -> {
                texto = "Você perdeu acesso ao nosso sistema";
            }
        }
        dados.put("nome", pessoa.getNome());
        dados.put("texto", texto);
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template-pessoa.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getEnderecoTemplate(PessoaEntity pessoa, EnderecoEntity endereco, int acao) throws Exception {
        Map<String, Object> dados = new HashMap<>();
        String texto = "";
        switch(acao) {
            case 1 -> {
                texto = "Foi adicionado um novo endereço a sua conta,";
            }
            case 2 -> {
                texto = "Seu endereço foi editado com sucesso";
            }
            case 3 -> {
                texto = "Seu endereço foi excluido com sucesso";
            }
        }
        dados.put("nome", pessoa.getNome());
        dados.put("texto", texto);
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("numero", endereco.getNumero());
        dados.put("complemento", endereco.getComplemento());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template-endereco.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }
}