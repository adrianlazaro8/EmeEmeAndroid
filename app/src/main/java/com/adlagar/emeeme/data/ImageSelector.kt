package com.adlagar.emeeme.data

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import pl.aprilapps.easyphotopicker.*
import java.io.File

class ImageSelector(
    context: Context,
    private val fragment: Fragment,
    multiplePicker: Boolean
) {

    var file: File? = null

    val easyImage: EasyImage = EasyImage.Builder(context)
        .setChooserTitle("Elige imagen")
        .setChooserType(ChooserType.CAMERA_AND_GALLERY)
        .setCopyImagesToPublicGalleryFolder(false)
        .setFolderName("EasyImage sample")
        .allowMultiple(multiplePicker)
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
        easyImage.handleActivityResult(
            requestCode,
            resultCode,
            data,
            fragment.requireActivity(),
            object : DefaultCallback() {
                override fun onMediaFilesPicked(imageFiles: Array<MediaFile>, source: MediaSource) {
                    if (imageFiles.isNotEmpty()) {
                        file = imageFiles[0].file
                        imagePath.invoke(file)
                    } else {
                        imagePath.invoke(null)
                    }
                }
            })
    }
}