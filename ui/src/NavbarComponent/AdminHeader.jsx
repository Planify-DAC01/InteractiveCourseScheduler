import React from "react";
import { Link, useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import ButtonGroup from "react-bootstrap/ButtonGroup";
import Dropdown from "react-bootstrap/Dropdown";
import DropdownButton from "react-bootstrap/DropdownButton";

const AdminHeader = () => {
  let navigate = useNavigate();

  const user = JSON.parse(sessionStorage.getItem("active-admin"));
  console.log(user);

  const adminLogout = () => {
    toast.success("Logged out!!!", {
      position: "top-center",
      autoClose: 1000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
    });
    sessionStorage.removeItem("active-admin");
    sessionStorage.removeItem("admin-jwtToken");
    window.location.href= '/home';
  };

  return (
    <ul className="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
      <li >
      {/* Dropdown for Timetable */}
      <DropdownButton
        as={ButtonGroup}
        title="Timetable"
        variant="primary"
        className="me-2"
      >
        <Dropdown.Item as={Link} to="/admin/timetable/search">
          View Timetable
        </Dropdown.Item>
      </DropdownButton>

      {/* Dropdown for Grade */}
      <DropdownButton
        as={ButtonGroup}
        title="Course"
        variant="success"
        className="me-2"
      >
        <Dropdown.Item as={Link} to="/admin/grade/add">
          Add Course
        </Dropdown.Item>
        <Dropdown.Item as={Link} to="/admin/grade/all">
          View Course
        </Dropdown.Item>
      </DropdownButton>

      {/* Dropdown for Course */}
      <DropdownButton
        as={ButtonGroup}
        title="Module"
        variant="success"
        className="me-2"
      >
        <Dropdown.Item as={Link} to="/admin/course/add">
          Add Module
        </Dropdown.Item>
        <Dropdown.Item as={Link} to="/admin/grade/all/course/">
          View Module
        </Dropdown.Item>
      </DropdownButton>

      {/* Dropdown for Batch */}
      <DropdownButton
        as={ButtonGroup}
        title="Batch"
        variant="info"
        className="me-2"
      >
        <Dropdown.Item as={Link} to="/admin/batch/add">
          New Batch
        </Dropdown.Item>
        <Dropdown.Item as={Link} to="/admin/grade/all/batch/">
          View Batches
        </Dropdown.Item>
        <Dropdown.Item as={Link} to="/teacher/batch/transfer">
          Transfer Batch
        </Dropdown.Item>
        <Dropdown.Item as={Link} to="/teacher/batch/deactivate">
          Deactivate Batch
        </Dropdown.Item>
      </DropdownButton>

      {/* Dropdown for Teacher */}
      <DropdownButton
        as={ButtonGroup}
        title="Teacher"
        variant="warning"
        className="me-2"
      >
        <Dropdown.Item as={Link} to="/user/teacher/register">
          Register Teacher
        </Dropdown.Item>
        <Dropdown.Item as={Link} to="/admin/teacher/all">
          View Teachers
        </Dropdown.Item>
      </DropdownButton>

      {/* Dropdown for Student */}
      <DropdownButton
        as={ButtonGroup}
        title="Student"
        variant="warning"
        className="me-2"
      >
        <Dropdown.Item as={Link} to="/user/student/register">
          Register Student
        </Dropdown.Item>
        <Dropdown.Item as={Link} to="/admin/student/all">
          View Students
        </Dropdown.Item>
      </DropdownButton>
      </li>
      {/* Logout Link */}
      <li className="nav-item">
      <button
          className="btn btn-danger me-2" // Red color
          onClick={adminLogout}
        >
          <b>Logout</b>
        </button>
        <ToastContainer />
      </li>
    </ul>
  );
};

export default AdminHeader;