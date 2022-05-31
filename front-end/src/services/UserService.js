import axios from "axios";

const RESTAPI_GET_ALL_USER = "http://localhost:8080/api/users";

const RESTAPI_DELETE_USER = "http://localhost:8080/api/delete/";

const RESTAPI_ADD_USER = "http://localhost:8080/api/create";

const RESTAPI_UPDATE_USER = "http://localhost:8080/api/update/";

class UserService {
  getUser() {
    return axios.get(RESTAPI_GET_ALL_USER);
  }
  deleteUser(id) {
    return axios.delete(RESTAPI_DELETE_USER + id);
  }
  addUser(newUser) {
    return axios.post(RESTAPI_ADD_USER, newUser);
  }

  updateUser(id, newUser) {
    return axios.put(RESTAPI_UPDATE_USER + id, newUser);
  }
}

export default new UserService();
