package com.kapozzz.workwithfiles

import android.content.Context
import android.util.Log
import java.io.File
import java.io.IOException
import java.util.UUID

abstract class FileProvider(
    private val context: Context
) {

    abstract fun saveFile(file: ByteArray): String?

    abstract fun getFromFile(fileName: String): ByteArray?

    fun clearOldestFiles() {
        val fileList = context.fileList()
        Log.i("WorkWithFiles", "Files to delete: ${fileList.toList()}")
        var lastFileName = ""
        try {
            fileList.forEach {
                lastFileName = it
                context.deleteFile(it)
                Log.i("WorkWithFiles", "File $it deleted")
            }
        } catch (e: IOException) {
            e.printStackTrace()
            Log.e("WorkWithFiles", "cannot delete file $lastFileName")
        }
        Log.i("WorkWithFiles", "All oldest files deleted")
    }

    fun showAllFiles() {
        val cacheFiles = context.cacheDir.listFiles()?.toList().toString()
        val savedInternalFiles = context.filesDir.listFiles()?.toList().toString()
        Log.i(("WorkWithFiles"), "cache files: $cacheFiles")
        Log.i(("WorkWithFiles"), "saved internal files: $savedInternalFiles")
    }
}

/** File provider for internal files **/
class InternalFileProvider(private val context: Context) : FileProvider(context) {

    var saveInCache: Boolean = false

    override fun saveFile(file: ByteArray): String? {
        val prefix = if (saveInCache) "cached" else "saved"
        val fileName = UUID.randomUUID().toString() + "_$prefix"
        try {
            if (saveInCache) {
                val tempFile = File(context.cacheDir, fileName)
                tempFile.writeBytes(file)
            } else {
                context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
                    it.write(file)
                }
            }
        } catch (e: IOException) {
            return null
        }
        return fileName
    }

    override fun getFromFile(fileName: String): ByteArray? {
        val file: ByteArray = try {
            if (saveInCache) {
                File(context.cacheDir, fileName).readBytes()
            } else {
                File(context.filesDir, fileName).readBytes()
            }
        } catch (e: IOException) {
            return null
        }
        return file
    }
}

/** File provider for shared files **/

//class SharedFileProvider(): File {
//
//}