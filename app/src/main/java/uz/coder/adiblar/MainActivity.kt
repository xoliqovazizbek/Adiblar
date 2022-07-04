package uz.coder.adiblar

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.FirebaseFirestore
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import uz.coder.adiblar.databinding.ActivityMainBinding
import uz.coder.adiblar.models.User

class MainActivity : AppCompatActivity() {

    lateinit var firebaseFirestore: FirebaseFirestore
    lateinit var binding: ActivityMainBinding
    var photoURl = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseFirestore = FirebaseFirestore.getInstance()

        Dexter.withContext(this)
            .withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) { /* ... */
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) { /* ... */
                }

                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest?,
                    token: PermissionToken?
                ) { /* ... */
                }
            }).check()


        binding.btnImg.setOnClickListener {
//                val getImageContent =
//                    registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
//                        uri ?: return@registerForActivityResult
//                        val ins = contentResolver?.openInputStream(uri)
//                        val file = File(filesDir, "imageNew.jpg")
//                        val absolutePath = file.absolutePath
//                        val fileOutputStream = FileOutputStream(file)
//                        Toast.makeText(this, "file copied to $absolutePath", Toast.LENGTH_LONG).show()
//                        binding.img.setImageURI(uri)
//                        ins?.copyTo(fileOutputStream)
//                        ins?.close()
//                        fileOutputStream.close()
//                    }
//                fun pickImageFromGalleryNew() {
//                    getImageContent.launch("image/*")
//                }

            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 100)

        }



        binding.save.setOnClickListener {

            val user = User()
//            firebaseFirestore.collection("users")
//                .add()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 100 && data != null) {
            binding.img.setImageURI(data.data)

        }

    }

}