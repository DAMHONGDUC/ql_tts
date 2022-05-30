import UserService from "../services/UserService";
import "bootstrap/dist/css/bootstrap.min.css";
import {
  Button,
  Card,
  Col,
  Container,
  Form,
  Modal,
  Row,
  Table,
} from "react-bootstrap";
import { Toggle } from "rsuite";
import { FaPencilAlt, FaPlus, FaTrashAlt } from "react-icons/fa";
import React, { useEffect, useState, Text } from "react";

export const Menu = (props) => {
  const [users, setUsers] = React.useState([]);

  useEffect(() => {
    UserService.getUser().then((response) => {
      setUsers(response.data);
    });
  }, []);

  const initCurrentUser = {
    id: null,
    tendangnhap: "",
    matkhau: "",
    ten: "",
    email: "",
    sdt: "",
  };

  const Spacer = require("react-spacer");
  const [newUser, setNewUser] = useState(initCurrentUser);
  const [editing, setEdit] = useState(false);
  const [showAdd, setShowAdd] = useState(false);
  const [showEdit, setShowEdit] = useState(false);
  const [currUser, setCurrUser] = useState(initCurrentUser);

  const handleCloseAdd = () => {
    setShowAdd(false);
  };
  const handleCloseEdit = () => {
    setShowEdit(false);
  };
  const handleAddUser = () => {
    setShowAdd(true);
    setNewUser(initCurrentUser);
  };

  const onFormSubmit = (newUser) => {
    const id = users.length + 1;
    setUsers([...users, { ...newUser, id }]);
  };

  const onEdit = (currUser) => {
    setShowEdit(true);
    setCurrUser({ ...currUser, currUser });
  };

  const onSubmitAdd = (newUser) => {
    onFormSubmit(newUser);
  };

  const onSubmitEdit = (currUser) => {
    onUpdateUser(currUser);
  };

  const onUpdateUser = (newUser) => {
    setEdit(false);
    let id = newUser.id;
    setUsers(users.map((i) => (i.id === id ? newUser : i)));
  };

  const onDeleteUser = (currentUser) => {
    UserService.deleteUser(currentUser.id).then((response) => {
      if (response.data === "Deleted user successfully") {
        setUsers(users.filter((i) => i.id !== currentUser.id));
      }
    });
  };

  return (
    <Container fluid="md">
      <Row>
        <Col>
          <Card className="customCard">
            <Card.Body>
              <div className="d-flex justify-content-between customCardBody">
                <div>
                  <Card.Title>Danh sách User</Card.Title>
                </div>
                <div className="d-flex">
                  <Button
                    variant="primary"
                    onClick={handleAddUser}
                    title="Thêm User"
                  >
                    <FaPlus />
                  </Button>
                </div>
              </div>
              <Spacer height={15} />
              <Table striped bordered hover variant="dark">
                <thead>
                  <tr>
                    <th>ID</th>
                    <th>TenDangNhap</th>
                    <th>MatKhau</th>
                    <th>Ten</th>
                    <th>Email</th>
                    <th>SDT</th>
                    <th>Xoá, Sửa</th>
                  </tr>
                </thead>
                <tbody>
                  {users.length > 0 ? (
                    users.map((user, index) => (
                      <tr key={index}>
                        <td>{user.id}</td>
                        <td>{user.tendangnhap}</td>
                        <td>{user.matkhau}</td>
                        <td>{user.ten}</td>
                        <td>{user.email}</td>
                        <td>{user.sdt}</td>
                        <td>
                          <Button
                            variant="info"
                            title="Sửa User"
                            onClick={() => onEdit(user)}
                          >
                            <FaPencilAlt />
                          </Button>{" "}
                          <Button
                            variant="danger"
                            title="Xoá User"
                            onClick={() => onDeleteUser(user)}
                          >
                            <FaTrashAlt />
                          </Button>
                        </td>
                      </tr>
                    ))
                  ) : (
                    <tr>
                      <td colSpan={6} className="text-center">
                        No users found.
                      </td>
                    </tr>
                  )}
                </tbody>
              </Table>
            </Card.Body>
          </Card>

          {/* Thêm user           */}
          <Modal size="lg" show={showAdd} onHide={handleCloseAdd}>
            <Form
              onSubmit={(e) => {
                e.preventDefault();
                onSubmitAdd(newUser);
              }}
            >
              <Modal.Header closeButton>
                <Modal.Title>Thêm User</Modal.Title>
              </Modal.Header>

              <Modal.Body>
                <Form.Group className="mb-3" controlId="formBasicName">
                  <Form.Label>Tên Đăng Nhập</Form.Label>
                  <Form.Control
                    type="text"
                    value={newUser.tendangnhap}
                    required
                    onChange={(e) =>
                      setNewUser({ ...newUser, tendangnhap: e.target.value })
                    }
                    placeholder="Nhập tên đăng nhập"
                  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicAddress">
                  <Form.Label>Mật Khẩu</Form.Label>
                  <Form.Control
                    type="text"
                    value={newUser.matkhau}
                    onChange={(e) =>
                      setNewUser({ ...newUser, matkhau: e.target.value })
                    }
                    placeholder="Nhập mật khẩu"
                  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicAge">
                  <Form.Label>Tên</Form.Label>
                  <Form.Control
                    type="text"
                    value={newUser.ten}
                    onChange={(e) =>
                      setNewUser({ ...newUser, ten: e.target.value })
                    }
                    placeholder="Nhập tên"
                  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicProfession">
                  <Form.Label>Email</Form.Label>
                  <Form.Control
                    type="text"
                    value={newUser.email}
                    onChange={(e) =>
                      setNewUser({ ...newUser, email: e.target.value })
                    }
                    placeholder="Nhập email"
                  />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>SĐT</Form.Label>
                  <Form.Control
                    type="text"
                    value={newUser.sdt}
                    onChange={(e) =>
                      setNewUser({ ...newUser, sdt: e.target.value })
                    }
                    placeholder="Nhập SĐT"
                  />
                </Form.Group>
              </Modal.Body>

              <Modal.Footer>
                <Button variant="secondary" onClick={handleCloseAdd}>
                  Close
                </Button>
                <Button
                  variant="primary"
                  type="submit"
                  onClick={handleCloseAdd}
                >
                  Submit
                </Button>
              </Modal.Footer>
            </Form>
          </Modal>

          {/* Sửa user           */}
          <Modal size="lg" show={showEdit} onHide={handleCloseEdit}>
            <Form
              onSubmit={(e) => {
                e.preventDefault();
                onSubmitEdit(currUser);
              }}
            >
              <Modal.Header closeButton>
                <Modal.Title>Sửa thông tin User</Modal.Title>
              </Modal.Header>

              <Modal.Body>
                <Form.Group className="mb-3" controlId="formBasicName">
                  <Form.Label>Tên Đăng Nhập</Form.Label>
                  <Form.Control
                    type="text"
                    value={currUser.tendangnhap}
                    required
                    onChange={(e) =>
                      setCurrUser({ ...currUser, tendangnhap: e.target.value })
                    }
                    placeholder="Nhập tên đăng nhập"
                  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicAddress">
                  <Form.Label>Mật Khẩu</Form.Label>
                  <Form.Control
                    type="text"
                    value={currUser.matkhau}
                    onChange={(e) =>
                      setCurrUser({ ...currUser, matkhau: e.target.value })
                    }
                    placeholder="Nhập mật khẩu"
                  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicAge">
                  <Form.Label>Tên</Form.Label>
                  <Form.Control
                    type="text"
                    value={currUser.ten}
                    onChange={(e) =>
                      setCurrUser({ ...currUser, ten: e.target.value })
                    }
                    placeholder="Nhập tên"
                  />
                </Form.Group>
                <Form.Group className="mb-3" controlId="formBasicProfession">
                  <Form.Label>Email</Form.Label>
                  <Form.Control
                    type="text"
                    value={currUser.email}
                    onChange={(e) =>
                      setCurrUser({ ...currUser, email: e.target.value })
                    }
                    placeholder="Nhập email"
                  />
                </Form.Group>
                <Form.Group className="mb-3">
                  <Form.Label>SĐT</Form.Label>
                  <Form.Control
                    type="text"
                    value={currUser.sdt}
                    onChange={(e) =>
                      setCurrUser({ ...currUser, sdt: e.target.value })
                    }
                    placeholder="Nhập SĐT"
                  />
                </Form.Group>
              </Modal.Body>

              <Modal.Footer>
                <Button variant="secondary" onClick={handleCloseEdit}>
                  Close
                </Button>
                <Button
                  variant="primary"
                  type="submit"
                  onClick={handleCloseEdit}
                >
                  Update
                </Button>
              </Modal.Footer>
            </Form>
          </Modal>
        </Col>
      </Row>
    </Container>
  );
};

export default Menu;
