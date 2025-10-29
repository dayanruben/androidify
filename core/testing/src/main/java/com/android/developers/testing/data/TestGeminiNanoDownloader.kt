package com.android.developers.testing.data

import com.android.developers.androidify.data.GeminiNanoDownloader

class TestGeminiNanoDownloader(val modelDownloaded: Boolean) : GeminiNanoDownloader {
    override fun isModelDownloaded(): Boolean {
        return modelDownloaded
    }
}