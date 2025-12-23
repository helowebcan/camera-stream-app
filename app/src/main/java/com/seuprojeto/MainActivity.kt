package com.seuprojeto

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.camera.core.CameraSelector
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Cria a visualização da câmera
        val previewView = PreviewView(this)
        setContentView(previewView)

        // Inicializa o provedor da câmera
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)
        cameraProviderFuture.addListener({
            val cameraProvider = cameraProviderFuture.get()

            // Configura o preview
            val preview = androidx.camera.core.Preview.Builder().build()
            preview.setSurfaceProvider(previewView.surfaceProvider)

            // Seleciona a câmera traseira
            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            // Liga o ciclo de vida da câmera à Activity
            cameraProvider.bindToLifecycle(this, cameraSelector, preview)
        }, ContextCompat.getMainExecutor(this))
    }
}

