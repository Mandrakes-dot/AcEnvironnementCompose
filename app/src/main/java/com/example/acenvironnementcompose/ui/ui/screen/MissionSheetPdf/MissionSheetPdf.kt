package com.example.acenvironnementcompose.ui.ui.screen.MissionSheetPdf

import android.content.Context
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.acenvironnementcompose.ui.theme.AcEnvironnementComposeTheme
import com.github.barteksc.pdfviewer.PDFView
import java.io.File


@Composable
fun PdfScreen(param: Int) {
    PdfContent(param)
}

@Composable
fun ShowPdf(context: Context, pdfFilePath: String) {
    AndroidView(
        modifier = Modifier.fillMaxSize(),
        factory = { context ->
            PDFView(context, null).apply {
                fromFile(File(pdfFilePath))  // Provide the PDF file
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableDoubletap(true)
                    .load()
            }
        }
    )
}

@Composable
fun PdfContent(clientId: Int) {

    val context = LocalContext.current
    val pdfFile = File(context.filesDir, "ModifiedMissionOrder_Client_${clientId}.pdf")

    AndroidView(
        factory = { ctx ->
            PDFView(ctx, null).apply {
                fromFile(pdfFile)
                    .enableSwipe(true)
                    .enableDoubletap(true)
                    .load()
            }
        },
        modifier = Modifier.fillMaxSize()
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AcEnvironnementComposeTheme {
        PdfScreen(1)
    }
}