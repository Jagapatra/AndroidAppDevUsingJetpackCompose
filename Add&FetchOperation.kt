package com.example.testapp2

import android.content.ContentValues.TAG
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import android.graphics.Color.parseColor
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
//import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.modifier.modifierLocalProvider
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import com.google.firebase.firestore.toObject

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val userList = remember {
                mutableStateOf<List<User>>(emptyList())
            }
            LaunchedEffect(Unit) {
                fetchStudents { users ->
                    userList.value=users
                }
            }
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            ) {
                items(userList.value){
                    user->
                    Text(text = "Name: ${user.name} , Age: ${user.Age} , Sic: ${user.Sic}")
                }
            }
        }
    }
    val db = Firebase.firestore
    fun addUser(name:String,age:Int,sic:String){
        val user = User(name,age,sic)
        db.collection("User")
            .add(user)
            .addOnSuccessListener { docRef ->
                Log.d(TAG,"Document snapshot added with id: ${docRef.id}")
            }
            .addOnFailureListener{ e ->
                Log.w(TAG,"Error Adding document")
            }

    }

    fun addUserBySic(name:String,age:Int,sic:String){
        val user = User(name,age,sic)
        db.collection("Silicon Database")
            .document(sic)
            .set(user)

    }

    fun fetchStudents(onResult: (List<User>)->Unit){
        db.collection("Students")
            .get()
            .addOnSuccessListener { result->
                val userList =result.map { document ->document.toObject(User::class.java) }
                onResult(userList)
            }
            .addOnFailureListener{e->
                Log.w(TAG,"Errorgetting document:",e)
            }
    }


    @Composable
    fun AddUserScreen(){
        var name by remember { mutableStateOf("") }
        var age by remember { mutableStateOf("") }
        var sic by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .padding(15.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(value = name, onValueChange = {name=it},
                label = { Text(text = "Enter Name")},
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(18.dp))

            TextField(value = age, onValueChange = {age=it},
                label = { Text(text = "Enter Age")},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(18.dp))

            TextField(value = sic, onValueChange = {sic=it},
                label = { Text(text = "Enter Sic")},
                modifier = Modifier.fillMaxWidth())

            Spacer(modifier = Modifier.height(18.dp))

            Button(onClick = {addUserBySic(name,age.toInt(),sic)}) {
                Text(text = "Add User to database")
            }

        }
    }
}

//Data/model Class
data class User(
    var name:String="",
    var Age:Int=0,
    var Sic:String=""
)

























/*
@Composable
fun CounterScreen(){
    var count: Int by remember {
        mutableStateOf( 0)
    }
    var text: String by remember {
        mutableStateOf( " ")
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ){
        Text(text="The count value is $count")
        Spacer(modifier = Modifier.height(10.dp))
        Button(onClick = { count++ }) {
            Text(text = "Increment")
        }
        Button(onClick = { count-- }) {
            Text(text = "Decrement")
        }
        TextField(
            value = text ,
            onValueChange = { text=it },
            label = { Text ("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}
*/

