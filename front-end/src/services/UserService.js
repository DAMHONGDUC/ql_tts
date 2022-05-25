import axios from "axios";

const URL_USER_REST_API = "http://localhost:8080/api/users";

class UserService {
  getUser() {
    return axios.get(URL_USER_REST_API);
  }
}

export default new UserService();
