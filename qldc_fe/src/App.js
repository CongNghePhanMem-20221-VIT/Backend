import React from "react";
import Login from "./Pages/Login";
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom'
import Home from "./Pages/Home/Home";
function App() {
  return (
    <Router>
      <div className="app">
        <Routes>
          <Route exact path="/" element={<Login />} />
          <Route exact path="/Home" element={<Home />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
