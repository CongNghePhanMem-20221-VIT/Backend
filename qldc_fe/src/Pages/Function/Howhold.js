import React from "react";

const howholdLists = [
    {
        id: 1,
        diaChi: "VIT-Đội SVTN trường CNTT&TT",
        ngayTao: "2023-02-03",
        idKhuVuc: "BK",
        idGiaDinh: "BK000",
        hoTen: "Đinh Trọng Nghĩa",
        ngaySinh: "2001-01-05",
        ngheNghiep: "Sinh viên",
        quanHeVoiChuHo: "Chủ hộ",
        diaChiHienTai: null,
        canCuoc: "000000000001"
    },
    {
        id: 3,
        diaChi: "Số 1 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        ngayTao: "2023-02-03",
        idKhuVuc: "BK",
        idGiaDinh: "BK002",
        hoTen: "Trịnh Văn An",
        ngaySinh: "1990-12-06",
        ngheNghiep: "Giáo Viên",
        quanHeVoiChuHo: "Chủ hộ",
        diaChiHienTai: "Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        canCuoc: "000000000003"
    },
    {
        id: 2,
        diaChi: "Số 2 Tạ Quang Bửu, quần Hai Bà Trưng, Hà Nội",
        ngayTao: "2023-02-03",
        idKhuVuc: "BK",
        idGiaDinh: "BK001",
        hoTen: "Nguyễn Minh Quân",
        ngaySinh: "1995-05-30",
        ngheNghiep: "Kỹ sư",
        quanHeVoiChuHo: "Chủ hộ",
        diaChiHienTai: "Số 2 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        canCuoc: "000000000002"
    },
    {
        id: 4,
        diaChi: "Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        ngayTao: "2023-02-03",
        idKhuVuc: "BK",
        idGiaDinh: "BK003",
        hoTen: "Nguyễn Tiến Dũng",
        ngaySinh: "1964-06-02T16:00:00.000+00:00",
        ngheNghiep: "Kỹ sư",
        quanHeVoiChuHo: "Chủ hộ",
        diaChiHienTai: "Số 4 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        canCuoc: "000000000004"
    },
    {
        id: 5,
        diaChi: "Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        ngayTao: "2023-02-03",
        idKhuVuc: "BK",
        idGiaDinh: "BK004",
        hoTen: "Trần Văn Nam",
        ngaySinh: "1980-07-08",
        ngheNghiep: "Luật sư",
        quanHeVoiChuHo: "Chủ hộ",
        diaChiHienTai: "Số 4 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        canCuoc: "000000000005"
    }
]

const Howhold = () => {
    return (
        <div className="container">
            <table className="custom table table-bordered table-striped">
                <tr className="field">
                    <th>STT</th>
                    <th>Tên chủ hộ</th>
                    <th>Số Căn cước</th>
                    <th>Địa chỉ</th>
                    <th>Mã khu vực</th>
                    <th>Mã gia đình</th>
                    <th>Ngày tạo</th>
                </tr>
                <tbody id="myTable">
                    {
                        howholdLists.map((howhold, index) => (
                            <tr className="data">
                                <td>{howhold.id}</td>
                                <td>{howhold.hoTen}</td>
                                <td>{howhold.canCuoc}</td>
                                <td>{howhold.diaChi}</td>
                                <td>{howhold.idKhuVuc}</td>
                                <td>{howhold.idGiaDinh}</td>
                                <td>{howhold.ngayTao}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    )
}

export default Howhold