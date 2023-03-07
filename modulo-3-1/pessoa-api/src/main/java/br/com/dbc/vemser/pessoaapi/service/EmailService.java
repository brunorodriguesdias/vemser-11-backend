package br.com.dbc.vemser.pessoaapi.service;

import br.com.dbc.vemser.pessoaapi.entity.Endereco;
import br.com.dbc.vemser.pessoaapi.entity.Pessoa;
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

    public void sendEmail(String template) throws RegraDeNegocioException {
        MimeMessage mimeMessage = emailSender.createMimeMessage();
        try {

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(from);
            mimeMessageHelper.setTo(TO);
            mimeMessageHelper.setSubject("E-mail Template");
            mimeMessageHelper.setText(template, true);

            emailSender.send(mimeMessageHelper.getMimeMessage());
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RegraDeNegocioException("ERRO ao enviar e-mail.");
        }
    }

    public String getContentFromTemplate() throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", "Pessoal do sistema");

        Template template = fmConfiguration.getTemplate("email-template.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getPessoaTemplate(Pessoa pessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("id", pessoa.getIdPessoa());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template-pessoa.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getEdicaoPessoaTemplate(Pessoa pessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("id", pessoa.getIdPessoa());
        dados.put("nascimento", pessoa.getDataNascimento());
        dados.put("cpf", pessoa.getCpf());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template-edicaoPessoa.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getDelecaoPessoaTemplate(Pessoa pessoa) throws IOException, TemplateException {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template-delecaoPessoa.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getCriandoEnderecoTemplate(Endereco endereco, Pessoa pessoa) throws Exception {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("tipo", endereco.getTipo());
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("numero", endereco.getNumero());
        dados.put("complemento", endereco.getComplemento());
        dados.put("cep", endereco.getCep());
        dados.put("cidade", endereco.getCidade());
        dados.put("estado", endereco.getEstado());
        dados.put("pais", endereco.getPais());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template-criandoEndereco.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getEdicaoEnderecoTemplate(Endereco endereco, Pessoa pessoa) throws Exception {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("tipo", endereco.getTipo());
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("numero", endereco.getNumero());
        dados.put("complemento", endereco.getComplemento());
        dados.put("cep", endereco.getCep());
        dados.put("cidade", endereco.getCidade());
        dados.put("estado", endereco.getEstado());
        dados.put("pais", endereco.getPais());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template-edicaoEndereco.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }

    public String getDelecaoEnderecoTemplate(Endereco endereco, Pessoa pessoa) throws Exception {
        Map<String, Object> dados = new HashMap<>();
        dados.put("nome", pessoa.getNome());
        dados.put("tipo", endereco.getTipo());
        dados.put("logradouro", endereco.getLogradouro());
        dados.put("numero", endereco.getNumero());
        dados.put("email", from);

        Template template = fmConfiguration.getTemplate("email-template-delecaoEndereco.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, dados);
        return html;
    }


}