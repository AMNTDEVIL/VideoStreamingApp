import 'package:flutter/material.dart';

class CustomTextField extends StatefulWidget {
  final String labelText;
  final bool obsecureText;
  final Icon icon;
  final TextEditingController controller;
  final bool filled;
  final bool readOnly;

  const CustomTextField({
    required this.readOnly,
    required this.filled,
    required this.controller,
    required this.labelText,
    required this.obsecureText,
    required this.icon,
    Key? key,
  }) : super(key: key);

  @override
  State<CustomTextField> createState() => _CustomTextFieldState();
}

class _CustomTextFieldState extends State<CustomTextField> {
  late bool _isObscured;

  @override
  void initState() {
    super.initState();
    _isObscured = widget.obsecureText;
  }

  @override
  Widget build(BuildContext context) {
    double width = MediaQuery.of(context).size.width * 0.8;

    return Padding(
      padding: const EdgeInsets.all(12),
      child: SizedBox(
        width: width,
        child: TextFormField(
          controller: widget.controller,
          obscureText: _isObscured,
          readOnly: widget.readOnly,
          decoration: InputDecoration(
            prefixIcon: widget.icon,
            labelText: widget.labelText,
            filled: widget.filled,
            labelStyle: const TextStyle(
              color: Colors.purple,
              fontSize: 20,
              fontWeight: FontWeight.bold,
            ),
            border: OutlineInputBorder(
              borderRadius: BorderRadius.circular(12),
              borderSide: BorderSide.none,
            ),
            focusedBorder: const OutlineInputBorder(
              borderSide: BorderSide(color: Colors.blue),
            ),
            suffixIcon: widget.obsecureText
                ? IconButton(
                    onPressed: () {
                      setState(() {
                        _isObscured = !_isObscured;
                      });
                    },
                    icon: Icon(
                      _isObscured ? Icons.visibility_off : Icons.visibility,
                    ),
                  )
                : null,
          ),
        ),
      ),
    );
  }
}
