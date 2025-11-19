package com.matheusmarques.nfgeneration.consumer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.matheusmarques.nfgeneration.dto.NotaFiscalDTO;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import com.matheusmarques.nfgeneration.service.PdfService;

@Service
public class NotaFiscalConsumer {

    private final PdfService pdfService;
    private final ObjectMapper mapper = new ObjectMapper();

    public NotaFiscalConsumer(PdfService pdfService) {
        this.pdfService = pdfService;
    }

    @KafkaListener(topics = "nota-fiscal")
    public void receberMensagem(String mensagem) {
        try {
            NotaFiscalDTO dto = mapper.readValue(mensagem, NotaFiscalDTO.class);
            pdfService.gerarPdf(dto);
            System.out.println("PDF gerado para NF: " + dto.getNumero());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
