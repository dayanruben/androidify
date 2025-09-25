package com.android.developers.testing.network

import android.graphics.Bitmap
import com.android.developers.androidify.ondevice.LocalSegmentationDataSource
import androidx.core.graphics.createBitmap

class TestLocalSegmentationDataSource() : LocalSegmentationDataSource {

    override suspend fun removeBackground(bitmap: Bitmap): Bitmap {
        return createBitmap(100, 100)
    }
}