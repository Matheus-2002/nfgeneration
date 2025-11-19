package com.matheusmarques.nfgeneration.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.matheusmarques.nfgeneration.dto.NotaFiscalDTO;

import java.io.File;
import java.io.FileOutputStream;

public class PdfGenerator {

    public static void gerar(NotaFiscalDTO nf, String folder) {
        try {
            File dir = new File(folder);
            if (!dir.exists()) dir.mkdirs();

            String path = folder + "/NF-" + nf.getNumero() + ".pdf";

            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(path));

            document.open();

            document.add(new Paragraph("NOTA FISCAL", new Font(Font.FontFamily.HELVETICA, 20, Font.BOLD)));
            document.add(new Paragraph("\nNúmero: " + nf.getNumero()));
            document.add(new Paragraph("Cliente: " + nf.getCliente()));
            document.add(new Paragraph("Valor: R$ " + nf.getValor()));
            document.add(new Paragraph("Descrição: " + nf.getDescricao()));

            document.close();

            System.out.println("PDF salvo em: " + path);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}