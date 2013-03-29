struct User {
  1: i32 id;
  2: string name;
  3: optional i32 born;
}

service UserService {
  User getUserById(1: i32 id);
}