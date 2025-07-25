import 'package:flutter/material.dart';
import 'package:frontend/widgets/CustomButton.dart';
import 'package:frontend/widgets/CustomTextfield.dart';

class UserRegistration extends StatefulWidget {
  const UserRegistration({super.key});

  @override
  UserRegistrationState createState() => UserRegistrationState();
}

class UserRegistrationState extends State<UserRegistration> {
  final TextEditingController emailController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          "User Login",
          style: TextStyle(
            color: Colors.amberAccent,
            fontSize: 30,
            fontWeight: FontWeight.bold,
          ),
        ),
        centerTitle: true,
      ),
      body: SingleChildScrollView(
        child: Center(
          child: Column(
            children: [
              CustomTextField(
                controller: emailController,
                labelText: "Email",
                obsecureText: false,
                icon: const Icon(Icons.email),
                readOnly: false,
                filled: false,
              ),
              
              CustomTextField(
                controller: passwordController,
                labelText: "Password",
                obsecureText: true,
                icon: const Icon(Icons.lock),
                readOnly: false,
                filled: false,
              ),
             
              CustomButton(buttonText: "Login", height: 50, width: 100, onPressed: (){})
            ],
          ),
        ),
      ),
    );
  }
}
