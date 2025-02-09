import { useNavigate } from "react-router-dom";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";

const HeaderStudent = () => {
  let navigate = useNavigate();

  const student = JSON.parse(sessionStorage.getItem("active-student"));

  const userLogout = () => {
    toast.success("logged out!!!", {
      position: "top-center",
      autoClose: 1000,
      hideProgressBar: false,
      closeOnClick: true,
      pauseOnHover: true,
      draggable: true,
      progress: undefined,
    });
    sessionStorage.removeItem("active-student");
    sessionStorage.removeItem("student-jwtToken");
    window.location.href= '/home';
  };

  const viewStudentProfile = () => {
    navigate("/user/profile/detail", { state: student });
  };

  const navigateToTimetable = () => {
    navigate("/student/timetable");
  };

  return (
    <ul className="navbar-nav ms-auto mb-2 mb-lg-0 me-5">
      <li className="nav-item">
        <button
          className="btn btn-primary me-2" // Blue color
          onClick={navigateToTimetable}
        >
          <b>Time Table</b>
        </button>
      </li>

      <li className="nav-item">
        <button
          className="btn btn-warning me-2" // Green color
          onClick={viewStudentProfile}
        >
          <b>My Profile</b>
        </button>
      </li>

      <li className="nav-item">
        <button
          className="btn btn-danger me-2" // Red color
          onClick={userLogout}
        >
          <b>Logout</b>
        </button>
      </li>

      <ToastContainer />
    </ul>
  );
};

export default HeaderStudent;