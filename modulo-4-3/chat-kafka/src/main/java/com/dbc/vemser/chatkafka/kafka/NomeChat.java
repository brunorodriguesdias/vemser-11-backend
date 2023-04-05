package com.dbc.vemser.chatkafka.kafka;

public enum NomeChat {
    AA_GERAL("tocyztra-chat", 0),
    BRUNO("tocyztra-chat", 1),
    GABRIEL_MEIRA("tocyztra-chat", 2),
    GABRIEL_JESUS("tocyztra-chat", 3),
    JOAO("tocyztra-chat", 4),
    KELLY("tocyztra-chat", 5),
    LUCAS("tocyztra-chat", 6),
    MARCKLEN("tocyztra-chat", 7),
    MARIANA("tocyztra-chat", 8),
    MATHEUS("tocyztra-chat", 9),
    NICOLAS("tocyztra-chat", 10),
    PEDRO("tocyztra-chat", 11),
    THASSIO("tocyztra-chat", 12),
    MAICON("tocyztra-chat", 13),
    RAFAEL("tocyztra-chat", 14);

    private String topico;
    private Integer particao;

    NomeChat(String topico, Integer particao) {
        this.topico = topico;
        this.particao = particao;
    }

    public String getTopico() {
        return topico;
    }

    public Integer getParticao() {
        return particao;
    }
}
