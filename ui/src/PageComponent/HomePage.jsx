import React from 'react';
import { Link } from 'react-router-dom';
import Footer from '../NavbarComponent/Footer';
import timetable1 from '../images/timetable_1.png';
import timetable2 from '../images/timetable_2.png';

const HomePage = () => {
  return (
    <div className="container-fluid mb-5">
      <div style={{ height: '80vh' }}>
      <div className="container mt-5">
        <div className="row mt-5">
          <div className="col-md-8 text-color">
            <h1>Intractive Course Scheduler</h1>
            <br />
            <p>
            The demands of modern academic life require strong time management skills.  Our Time Management System empowers both students and faculty to take control of their schedules and achieve their academic objectives.  This system offers a range of tools, including customizable calendars for visualizing commitments, task lists for breaking down assignments, and reminder systems to ensure deadlines are met. By using these features, users can improve their organization, maintain focus, and ultimately, succeed in their academic pursuits.  
            </p>
            <section className="home-page-features">
        <h2>Key Features</h2><br></br>
        <div className="feature-list">
          <div className="feature">
            <i className="fas fa-calendar-alt"></i> {/* Font Awesome icon (add library if needed) */}
            <h4>Customizable Time Schedule</h4>
            <p>Visualize your commitments and schedule with ease.</p>
          </div>
          <div className="feature">
            <i className="fas fa-tasks"></i> {/* Font Awesome icon */}
            <h4>Task Lists</h4>
            <p>Break down assignments into manageable tasks and track progress.</p>
          </div>
          <div className="feature">
            <i className="fas fa-bell"></i> {/* Font Awesome icon */}
            <h4>Reminders</h4>
            <p>Never miss a deadline with timely reminders and notifications.</p>
          </div>
          {/* Add more features as needed */}
        </div>
      </section>
            <p>
              Say goodbye to manual scheduling headaches and hello to a smarter
              way of managing academic timetables. Whether you're a student
              looking for your class schedule or an administrator coordinating
              courses, our system ensures smooth operations and effective
              communication at every step.
            </p>
          </div>
          <div className="col-md-4">
            <img
              src={timetable2}
              alt="Timetable Management System"
              width="400"
              height="auto"
              className="img-fluid home-image"
            />
          </div>
        </div>
      
        <div className="row mt-5">
          <div className="col-md-4">
            <img
              src={timetable1}
              alt="Efficient Time Management System"
              width="350"
              height="auto"
              className="img-fluid home-image"
            />
          </div>
          <div className="col-md-8 text-color">
            <h1 className="ms-5">Efficient Time Management System</h1>
            <p className="ms-5">
            The demands of modern academic life require strong time management skills.  Our Time Management System empowers both students and faculty to take control of their schedules and achieve their academic objectives.  This system offers a range of tools, including customizable calendars for visualizing commitments, task lists for breaking down assignments, and reminder systems to ensure deadlines are met. By using these features, users can improve their organization, maintain focus, and ultimately, succeed in their academic pursuits.
            </p>
            <p className="ms-5">
              By leveraging technology to streamline time management processes,
              our system empowers users to be more productive and efficient in
              their daily activities. Whether you're juggling multiple classes,
              assignments, or extracurricular activities, our platform provides
              the tools you need to stay on track and achieve your objectives.
            </p>
            <Link to="/user/login" className="btn bg-color custom-bg-text ms-5">
              Get Started
            </Link>
          </div>
        </div>
      </div>
      </div>
      
      <hr />
      <Footer style={{ position: 'relative', bottom: 0, width: '100%', height: '50px' }} />
    </div>
  );
};

export default HomePage;