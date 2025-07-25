import 'package:flutter/material.dart';
import 'package:frontend/widgets/CustomButton.dart';
import 'package:frontend/widgets/CustomTextfield.dart';
import 'package:intl/intl.dart';

class UserRegistration extends StatefulWidget {
  const UserRegistration({super.key});

  @override
  UserRegistrationState createState() => UserRegistrationState();
}

class UserRegistrationState extends State<UserRegistration> {
  final TextEditingController firstNameController = TextEditingController();
  final TextEditingController lastNameController = TextEditingController();
  final TextEditingController userNameController = TextEditingController();
  final TextEditingController emailController = TextEditingController();
  final TextEditingController dobController = TextEditingController();
  final TextEditingController genderController = TextEditingController();
  final TextEditingController passwordController = TextEditingController();
  final TextEditingController confirmPasswordController = TextEditingController();
  final TextEditingController numberController = TextEditingController();

  Future<void> _selectDate() async {
    final DateTime? pickedDate = await showDatePicker(
      context: context,
      firstDate: DateTime(1950),
      lastDate: DateTime.now(),
      initialDate: DateTime.now(),
    );

    if (pickedDate != null) {
      String formattedDate = DateFormat('dd/MM/yyyy').format(pickedDate);
      setState(() {
        dobController.text = formattedDate;
      });
    }
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: const Text(
          "User Registration",
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
                controller: firstNameController,
                labelText: "First Name",
                obsecureText: false,
                icon: const Icon(Icons.supervised_user_circle),
                readOnly: false,
                filled: false,
              ),
              CustomTextField(
                controller: lastNameController,
                labelText: "Last Name",
                obsecureText: false,
                icon: const Icon(Icons.supervised_user_circle_sharp),
                readOnly: false,
                filled: false,
              ),
              CustomTextField(
                controller: userNameController,
                labelText: "Username",
                obsecureText: false,
                icon: const Icon(Icons.verified_user),
                readOnly: false,
                filled: false,
              ),
              GestureDetector(
                onTap: _selectDate,
                child: AbsorbPointer(
                  child: CustomTextField(
                    readOnly: true,
                    filled: true,
                    controller: dobController,
                    labelText: "Date of Birth",
                    obsecureText: false,
                    icon: const Icon(Icons.calendar_today),
                  ),
                ),
              ),
              CustomTextField(
                controller: emailController,
                labelText: "Email",
                obsecureText: false,
                icon: const Icon(Icons.email),
                readOnly: false,
                filled: false,
              ),
              CustomTextField(
                controller: genderController,
                labelText: "Gender",
                obsecureText: false,
                icon: const Icon(Icons.transgender),
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
              CustomTextField(
                controller: confirmPasswordController,
                labelText: "Confirm Password",
                obsecureText: true,
                icon: const Icon(Icons.lock_outline),
                readOnly: false,
                filled: false,
              ),
              CustomTextField(
                controller: numberController,
                labelText: "Phone Number",
                obsecureText: false,
                icon: const Icon(Icons.phone),
                readOnly: false,
                filled: false,
              ),
              CustomButton(buttonText: "Register", height: 50, width: 100, onPressed: (){})
            ],
          ),
        ),
      ),
    );
  }
}
