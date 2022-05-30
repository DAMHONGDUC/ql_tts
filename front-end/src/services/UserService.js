import axios from "axios";

const RESTAPI_GET_ALL_USER = "http://localhost:8080/api/users";

const RESTAPI_DELETE_USER = "http://localhost:8080/api/delete/";

class UserService {
  getUser() {
    return axios.get(RESTAPI_GET_ALL_USER);
  }
  deleteUser(id) {
    return axios.delete(RESTAPI_DELETE_USER + id);
  }
}

export default new UserService();
