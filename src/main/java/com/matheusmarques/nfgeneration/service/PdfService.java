package com.matheusmarques.nfgeneration.service;

import com.matheusmarques.nfgeneration.dto.NotaFiscalDTO;
import com.matheusmarques.nfgeneration.util.PdfGenerator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PdfService {

    @Value("${nf.pdf.output-folder}")
    private String outputFolder;

    public void gerarPdf(NotaFiscalDTO dto) {
        PdfGenerator.gerar(dto, outputFolder);
    }
}
