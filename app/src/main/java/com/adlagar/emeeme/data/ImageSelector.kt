package com.adlagar.emeeme.data

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import pl.aprilapps.easyphotopicker.*
import java.io.File

class ImageSelector(context: Context, private val fragment: Fragment) {

    var file: File? = null

    val easyImage: EasyImage = EasyImage.Builder(context) // Chooser only
        .setChooserTitle("Elige imagen")
        // Will tell chooser that it should show documents or gallery apps
        //.setChooserType(ChooserType.CAMERA_AND_DOCUMENTS)  you can use this or the one below
        .setChooserType(ChooserType.CAMERA_AND_GALLERY)
        // Setting to true will cause taken pictures to show up in the device gallery, DEFAULT false
        .setCopyImagesToPublicGalleryFolder(false) // Sets the name for images stored if setCopyImagesToPublicGalleryFolder = true
        .setFolderName("EasyImage sample") // Allow multiple picking
        .build()

    fun selectImage() {
        easyImage.openCameraForImage(fragment)
    }

    fun handleResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?,
        imagePath: (File?) -> Unit
    ) {
        easyImage.handleActivityResult(requestCode, resultCode, data, fragment.requireActivity(), object: DefaultCallback(){
            override fun onMediaFilesPicked(imageFiles: Array<MediaFile>, source: MediaSource) {
                if(imageFiles.isNotEmpty()){
                    file = imageFiles[0].file
                    imagePath.invoke(file)
                } else {
                    imagePath.invoke(null)
                }
            }
        })
    }
}