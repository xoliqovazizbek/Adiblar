package uz.coder.adiblar

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.firestore.FirebaseFirestore
import uz.coder.adiblar.databinding.ActivityMainBinding
import uz.coder.adiblar.models.User
import java.io.File
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    lateinit var firebaseFirestore: FirebaseFirestore
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseFirestore = FirebaseFirestore.getInstance()





            binding.btnImg.setOnClickListener {
                val getImageContent =
                    registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
                        uri ?: return@registerForActivityResult
                        val ins = contentResolver?.openInputStream(uri)
                        val file = File(filesDir, "imageNew.jpg")
                        val absolutePath = file.absolutePath
                        val fileOutputStream = FileOutputStream(file)
                        Toast.makeText(this, "file copied to $absolutePath", Toast.LENGTH_LONG).show()
                        binding.img.setImageURI(uri)
                        ins?.copyTo(fileOutputStream)
                        ins?.close()
                        fileOutputStream.close()
                    }
                fun pickImageFromGalleryNew() {
                    getImageContent.launch("image/*")
                }
            }



            binding.save.setOnClickListener {

                val user = User()
//            firebaseFirestore.collection("users")
//                .add()
            }
        }

    }