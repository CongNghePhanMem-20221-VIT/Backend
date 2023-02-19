import React from 'react';

export default function Search() {

    return (
        <div class="container"
            style={{ width: "20%", padding: "2px" }}>
            <h2>Tìm kiếm</h2>
            <p>Nhập thông tin tìm kiếm dưới đây:</p>
            <input class="form-control" id="myInput" type="text" placeholder="Search.." />
            <br />
        </div>
    );
}