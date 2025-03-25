package com.example.acenvironnementcompose.logic.pdf

import android.content.Context
import android.net.Uri
import com.example.acenvironnement.room.MissionSheetDao
import com.example.acenvironnementcompose.logic.model.MissionSheetsModel
import com.example.acenvironnementcompose.logic.room.AppDatabase
import com.example.acenvironnementcompose.logic.room.MissionSheet
import com.itextpdf.kernel.font.PdfFontFactory
import com.itextpdf.kernel.pdf.PdfDocument
import com.itextpdf.kernel.pdf.PdfPage
import com.itextpdf.kernel.pdf.PdfReader
import com.itextpdf.kernel.pdf.PdfWriter
import com.itextpdf.kernel.pdf.canvas.PdfCanvas
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import java.io.File
import java.io.FileOutputStream
import java.io.InputStream
import javax.inject.Inject

class PdfGenerator @Inject constructor(
    private val missionSheetDao: MissionSheetDao
) {

    suspend fun addTextToPdf(context: Context, clientId: Int, missionSheetsModel: MissionSheetsModel) {

        val pdfFile = copyPdfFromAssets(context, "mission_order.pdf")

        val pdfReader = PdfReader(pdfFile)

        val modifiedPdfFile = File(context.filesDir, "ModifiedMissionOrder_Client_${clientId}.pdf")

        val pdfWriter = PdfWriter(modifiedPdfFile.path)

        val pdfDocument = PdfDocument(pdfReader, pdfWriter)

        val page: PdfPage = pdfDocument.getPage(1)
        val canvas = PdfCanvas(page)

        val mission = missionSheetsModel.diagnosticList

        mission.map {
            it.type
        }

        ////////////////////Ordre de mission///////////////////////

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(178.0, 653.42)
            .showText("X1")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(295.0, 653.42)
            .showText("X2")
            .endText()

        ///////////////////////////////////////////////////////////

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(285.5, 599.42)
            .showText("Etages")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(177.0, 600.42)
            .showText("${missionSheetsModel.habitableSurface.toString()} m2")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(80.0, 600.42)
            .showText("Type")
            .endText()

        ////////////////////////////////////////////////////////////

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(130.0, 570.42)
            .showText(missionSheetsModel.fiscalNumber.toString())
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(130.0, 555.42)
            .showText(missionSheetsModel.cadastralSection)
            .endText()

        ///////////////////////Chauffage////////////////////////////

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(138.0, 488.0)
            .showText("X")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(187.0, 488.0)
            .showText("X2")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(241.0, 488.0)
            .showText("X3")
            .endText()

        /////////////////////////Adresse//////////////////////////////

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(130.0, 293.0)
            .showText(missionSheetsModel.address)
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(100.0, 278.0)
            .showText(missionSheetsModel.postalCode)
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(213.0, 278.0)
            .showText("Ville")
            .endText()

        //////////////////////////Diag Vente/////////////////////////////

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(398.0, 600.42)
            .showText("X1")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(398.0, 585.0)
            .showText("X2")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(398.0, 570.0)
            .showText("X3")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(398.0, 555.42)
            .showText("X4")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(398.0, 540.0)
            .showText("X5")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(398.0, 525.0)
            .showText("X6")
            .endText()

        ///////////////////// Second Row

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(471.0, 600.42)
            .showText("X11")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(471.0, 585.0)
            .showText("X12")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(471.0, 570.0)
            .showText("X13")
            .endText()

    //////////////////////////Diag Location////////////////////////////

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(398.0, 438.0)
            .showText("X1")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(398.0, 423.0)
            .showText("X2")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(398.0, 408.0)
            .showText("X3")
            .endText()

        ///////////////////Second row

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(470.0, 438.0)
            .showText("X11")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(470.0, 423.0)
            .showText("X12")
            .endText()

        canvas.beginText()
            .setFontAndSize(PdfFontFactory.createFont(), 12f)
            .moveText(471.0, 408.0)
            .showText("X13")
            .endText()

        ///////////////////////////tarrif//////////////////////////////

        pdfDocument.close()

        saveMissionSheetWithPdfPath(context, modifiedPdfFile, clientId)
    }

    private fun copyPdfFromAssets(context: Context, assetFileName: String): File {

        val inputStream: InputStream = context.assets.open(assetFileName)
        val tempFile = File(context.cacheDir, assetFileName)

        FileOutputStream(tempFile).use { outputStream ->
            val buffer = ByteArray(1024)
            var length: Int
            while (inputStream.read(buffer).also { length = it } > 0) {
                outputStream.write(buffer, 0, length)
            }
        }
        return tempFile
    }

    private suspend fun saveMissionSheetWithPdfPath(context: Context, outputPdfFile: File, clientId: Int) {
        val filePath = outputPdfFile.path ?: return

        val missionSheet = MissionSheet(
            clientId = clientId,
            filePath = filePath
        )

        missionSheetDao.insertMissionSheet(missionSheet)
    }
}
