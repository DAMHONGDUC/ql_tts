import axios from "axios";

const RESTAPI_GET_ALL_USER = "http://localhost:8080/api/users";

class UserService {
  getUser() {
    return axios.get(RESTAPI_GET_ALL_USER);
  }
}

export default new UserService();
