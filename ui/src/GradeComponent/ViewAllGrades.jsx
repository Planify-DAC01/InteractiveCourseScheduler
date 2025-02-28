import { useState, useEffect } from "react";
import axios from "axios";
import React from "react";
import { useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

const ViewAllGrades = () => {
  const [allGrades, setAllGrades] = useState([]);
  const admin_jwtToken = sessionStorage.getItem("admin-jwtToken");

  let navigate = useNavigate();

  useEffect(() => {
    const getAllGrade = async () => {
      const allGrades = await retrieveAllGrade();
      if (allGrades) {
        setAllGrades(allGrades.grades);
      }
    };

    getAllGrade();
  }, []);

  const retrieveAllGrade = async () => {
    const response = await axios.get(
      "http://localhost:8080/api/grade/fetch/all"
    );
    console.log(response.data);
    return response.data;
  };

  const deleteGrade = (gradeId, e) => {
    fetch("http://localhost:8080/api/grade/delete?gradeId=" + gradeId, {
      method: "DELETE",
      headers: {
        Accept: "application/json",
        "Content-Type": "application/json",
        Authorization: "Bearer " + admin_jwtToken,
      },
    })
      .then((result) => {
        result.json().then((res) => {
          if (res.success) {
            toast.success(res.responseMessage, {
              position: "top-center",
              autoClose: 1000,
              hideProgressBar: false,
              closeOnClick: true,
              pauseOnHover: true,
              draggable: true,
              progress: undefined,
            });

            setTimeout(() => {
              window.location.reload(true);
            }, 1000); // Redirect after 3 seconds
          } else if (!res.success) {
            toast.error(res.responseMessage, {
              position: "top-center",
              autoClose: 1000,
              hideProgressBar: false,
              closeOnClick: true,
              pauseOnHover: true,
              draggable: true,
              progress: undefined,
            });
            setTimeout(() => {
              window.location.reload(true);
            }, 1000); // Redirect after 3 seconds
          }
        });
      })
      .catch((error) => {
        console.error(error);
        toast.error("It seems server is down", {
          position: "top-center",
          autoClose: 1000,
          hideProgressBar: false,
          closeOnClick: true,
          pauseOnHover: true,
          draggable: true,
          progress: undefined,
        });
        setTimeout(() => {
          window.location.reload(true);
        }, 1000); // Redirect after 3 seconds
      });
  };

  const updateGrade = (grade) => {
    navigate("/admin/grade/update", { state: grade });
  };

  const viewCourses = (gradeId) => {
    navigate(`/admin/grade/${gradeId}/course/`);
  };

  const viewBatches = (gradeId) => {
    navigate(`/admin/grade/${gradeId}/batch/`);
  };

  return (
    <div className="mt-3">
      <div
        className="card form-card ms-2 me-2 mb-5 shadow-lg"
        style={{
          height: "45rem",
          margin: "2%"
        }}
      >
        <div
          className="card-header custom-bg-text text-center bg-color"
          style={{
            borderRadius: ".5em",
            margin: "2%",
            height: "50px",
          }}
        >
          <h2>All Course</h2>
        </div>
        <div
          className="card-body"
          style={{
            overflowY: "auto",
          }}
        >
          <div className="table-responsive" style={{
            borderRadius: ".5em",
            margin:"1%",
            height: "90%",
          }}>
            <table className="table table-hover text-color text-center">
              <thead className="table-bordered border-color bg-color custom-bg-text">
                <tr>
                  <th scope="col">Course Id</th>
                  <th scope="col">Course Name</th>
                  <th scope="col">Description</th>
                  <th scope="col">Action</th>
                </tr>
              </thead>
              <tbody>
                {allGrades.map((grade) => {
                  return (
                    <tr>
                      <td>
                        <b>{grade.id}</b>
                      </td>
                      <td>
                        <b>{grade.name}</b>
                      </td>
                      <td>
                        <b>{grade.description}</b>
                      </td>
                      <td>
                        <button
                          onClick={() => updateGrade(grade)}
                          className="btn btn-sm bg-color custom-bg-text ms-2"
                        >
                          Update
                        </button>

                        <button
                          onClick={() => deleteGrade(grade.id)}
                          className="btn btn-sm bg-color custom-bg-text ms-2"
                        >
                          Delete
                        </button>

                        <button
                          onClick={() => viewCourses(grade.id)}
                          className="btn btn-sm bg-color custom-bg-text ms-2"
                        >
                          Module
                        </button>
                        <button
                          onClick={() => viewBatches(grade.id)}
                          className="btn btn-sm bg-color custom-bg-text ms-2"
                        >
                          Batches
                        </button>
                      </td>
                    </tr>
                  );
                })}
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>
  );
};

export default ViewAllGrades;
