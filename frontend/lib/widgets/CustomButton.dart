import 'package:flutter/material.dart';

class CustomButton extends StatelessWidget {
  final String buttonText;
  final VoidCallback? onPressed;
  final double width;
  final double height;
  const CustomButton({required this.buttonText,required this.height,required this.width ,required this.onPressed,super.key});
  @override
  Widget build(BuildContext context) {
    return ElevatedButton(onPressed: onPressed,style: ElevatedButton.styleFrom(
      backgroundColor: Colors.amberAccent,
      fixedSize: Size(width, height),
      shape: RoundedRectangleBorder(
        borderRadius: BorderRadius.circular(30),
      )
    ) ,child: Text(buttonText));
  }
}