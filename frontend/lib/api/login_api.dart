import 'dart:convert';

import 'package:http/http.dart' as http;

Future<bool> login(String email, String password) async{
  final url= Uri.parse('http://localhost/api/login');
  final response= await http.post(
    url,
    headers:{'Content-Type':'application/json'},
    body: jsonEncode({'email':email,'password':password})
  );
  if (response.statusCode==200) {
    return true;
  }
  else{
    final error=jsonDecode(response.body);
    print("login failed!"+error);
    return false;
  }
}