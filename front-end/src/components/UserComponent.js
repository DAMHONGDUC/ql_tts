import React from "react";
import UserService from "../services/UserService";

class UserComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = { users: [] };
  }
  componentDidMount() {
    UserService.getUser().then((response) => {
      this.setState({ users: response.data });
    });
  }
  render() {
    return (
      <div>
        <h1 className="text-center"> Danh sach User</h1>
        <table className="table table-striped">
          <thead>
            <tr>
              <td>ID</td>
              <td>Ten Dang Nhap</td>
              <td>MatKhau</td>
              <td>Ten</td>
              <td>Email</td>
              <td>SDT</td>
            </tr>
          </thead>
          <tbody>
            {this.state.users.map((user) => (
              <tr key={user.id}>
                <td>{user.id}</td>
                <td>{user.tendangnhap}</td>
                <td>{user.matkhau}</td>
                <td>{user.ten}</td>
                <td>{user.email}</td>
                <td>{user.sdt}</td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default UserComponent;
