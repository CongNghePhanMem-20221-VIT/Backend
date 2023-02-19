import React, { useState, useEffect } from "react";
import Howhold from "../Function/Howhold";
import Person from "../Function/Person";
import Search from "../Function/Search";

const Home = () => {
    const [close, setClose] = useState(false)
    const [person, setPerson] = useState(false)
    const [howhold, setHowhold] = useState(false)
    return (
        <div className="home">
            <div className="header">
                <strong style={{ color: "white", fontSize: "30px", }}>QUẢN LÝ DÂN CƯ</strong>
            </div>
            <div style={{ display: "flex", flexDirection: "row" }}>
                <div className="function">
                    <ul className="navbar">
                        <li className="nav_item" id="special">Quản lý nhân khẩu
                            <ul className="item">
                                <li className="nav_item child">Thay đổi nhân khẩu</li>
                                <li className="nav_item child">Thêm nhân khẩu</li>
                                <li className="nav_item child">Xoá nhân khẩu</li>
                                <li className="nav_item child">Tạm trú/Tạm vắng</li>
                            </ul>
                        </li>
                        <li className="nav_item" id="special">Quản lý hộ khẩu
                            <ul className="item">
                                <li className="nav_item child">Thay đổi hộ khẩu</li>
                                <li className="nav_item child">Thêm hộ khẩu</li>
                                <li className="nav_item child">Xoá hộ khẩu</li>
                            </ul>
                        </li>
                        <li className="nav_item">Quản lý cấp thưởng</li>
                        <li className="nav_item special" id="special">Tìm kiếm
                            <ul className="item">
                                <li className="nav_item child"
                                    onClick={() => {
                                        setClose(true)
                                        setPerson(true)
                                        setHowhold(false)
                                    }}
                                >Nhân khẩu</li>
                                <li className="nav_item child"
                                    onClick={() => {
                                        setClose(true)
                                        setHowhold(true)
                                        setPerson(false)
                                    }}
                                >Hộ khẩu</li>
                                <li className="nav_item child">Tạm trú/tạm vắng</li>
                            </ul>
                        </li>
                    </ul>
                </div>
                <div className="work">
                    {close
                        ? <div className="close_btn"
                            onClick={() => {
                                setClose(false)
                                setPerson(false)
                                setHowhold(false)
                            }}
                        >
                            &times;
                        </div>
                        : <div></div>}
                    {person ? <Person />
                        : <div></div>}
                    {howhold ? <Howhold />
                        : <div></div>}
                </div>

                <Search />

            </div>


        </div >
    )
}

export default Home