package uz.coder.adiblar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import uz.coder.adiblar.databinding.ActivityMainBinding
import uz.coder.adiblar.models.User

class MainActivity : AppCompatActivity() {

    lateinit var firebaseFirestore: FirebaseFirestore
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseFirestore = FirebaseFirestore.getInstance()


        binding.btnImg.setOnClickListener {

        }



        binding.save.setOnClickListener {

            val user = User()
//            firebaseFirestore.collection("users")
//                .add()
        }
    }

}