import React from 'react'

const personLists = [
    {
        id: 1,
        hoTen: "Đinh Trọng Nghĩa",
        ngaySinh: "2001-01-05",
        nguyenQuan: "Ninh Bình",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Sinh Viên",
        diaChiHienTai: "Số 1 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 26 Trần Nguyên Đán, phường Ba Đình,thị xã Bỉm Sơn,thanh Hoá",
        gioiTinh: "Nam",
        idcc: "000000000001"
    },
    {
        id: 2,
        hoTen: "Nguyễn Thế Vũ",
        ngaySinh: null,
        nguyenQuan: "Hà Nội",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Sinh Viên",
        diaChiHienTai: "Hà Nội",
        diaChiThuongTru: "Hà Nội",
        gioiTinh: "Nam",
        idcc: "000000000002"
    },
    {
        id: 3,
        hoTen: "Đào Tường Vinh",
        ngaySinh: null,
        nguyenQuan: "Nam Định",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Sinh Viên",
        diaChiHienTai: "Hà Nội",
        diaChiThuongTru: "Nam Định",
        gioiTinh: "Nam",
        idcc: "000000000003"
    },
    {
        id: 4,
        hoTen: "Phạm Hoàng Hiệp",
        ngaySinh: null,
        nguyenQuan: "Hải Phòng",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Sinh Viên",
        diaChiHienTai: "Hà Nội",
        diaChiThuongTru: "Hải Phòng",
        gioiTinh: "Nam",
        idcc: "000000000004"
    },
    {
        id: 5,
        hoTen: "Phạm Đức Hảo",
        ngaySinh: null,
        nguyenQuan: "Nam Định",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Sinh Viên",
        diaChiHienTai: "Hà Nội",
        diaChiThuongTru: "Nam Định",
        gioiTinh: "Nam",
        idcc: "000000000005"
    },
    {
        id: 6,
        hoTen: "Trịnh Văn An",
        ngaySinh: "1990-12-06",
        nguyenQuan: "Hà Nội",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Giáo Viên",
        diaChiHienTai: "Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 1 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nam",
        idcc: "000000000006"
    },
    {
        id: 7,
        hoTen: "Trầnthanh Duyên",
        ngaySinh: "1997-12-22",
        nguyenQuan: "Hải Phòng",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Nhân viên văn phòng",
        diaChiHienTai: "Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 3, đường Đình Đông, phường Đình Đông, quận Ngô Quyền, Hải Phòng",
        gioiTinh: "Nữ",
        idcc: "000000000007"
    },
    {
        id: 8,
        hoTen: "Nguyễn Minh Quân",
        ngaySinh: "1995-05-30",
        nguyenQuan: "Hà Nội",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Kỹ sư",
        diaChiHienTai: "Số 2 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 2 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nam",
        idcc: "000000000008"
    },
    {
        id: 9,
        hoTen: "Nguyễn Tiến Dũng",
        ngaySinh: "1964-06-02",
        nguyenQuan: "Hải Dương",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Kỹ sư",
        diaChiHienTai: "Số 4 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nam",
        idcc: "000000000009"
    },
    {
        id: 10,
        hoTen: "Vũ Mỹ Linh",
        ngaySinh: "1965-12-05",
        nguyenQuan: "Hà Nội",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Nội trợ",
        diaChiHienTai: "Số 3 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nữ",
        idcc: "000000000010"
    },
    {
        id: 11,
        hoTen: "Nguyễn Tiến Đạt",
        ngaySinh: "1990-09-08",
        nguyenQuan: "Hải Dương",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Kỹ sư",
        diaChiHienTai: "Số 3 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nam",
        idcc: "000000000011"
    },
    {
        id: 12,
        hoTen: "Nguyễn Trà My",
        ngaySinh: "1997-12-11",
        nguyenQuan: "Hải Dương",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Luật sư",
        diaChiHienTai: "Số 3 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 3 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nữ",
        idcc: "000000000012"
    },
    {
        id: 13,
        hoTen: "Trần Văn Nam",
        ngaySinh: "1980-07-08",
        nguyenQuan: "Hà Nội",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Luật sư",
        diaChiHienTai: "Số 4 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nam",
        idcc: "000000000013"
    },
    {
        id: 14,
        hoTen: "Nguyễn Minh Tuyết",
        ngaySinh: "1985-09-01",
        nguyenQuan: "Nam Định",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Bác sĩ",
        diaChiHienTai: "Số 4 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nữ",
        idcc: "000000000014"
    },
    {
        id: 15,
        hoTen: "Trần Trung Kiên",
        ngaySinh: "2008-12-24",
        nguyenQuan: "Hà Nội",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Học sinh",
        diaChiHienTai: "Số 4 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nam",
        idcc: "000000000015"
    },
    {
        id: 16,
        hoTen: "Trầnthúy Ngọc",
        ngaySinh: "2013-01-14",
        nguyenQuan: "Hà Nội",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Học sinh",
        diaChiHienTai: "Số 4 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 4 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nữ",
        idcc: "000000000016"
    },
    {
        id: 17,
        hoTen: "Lý Văn Công",
        ngaySinh: "1945-06-03",
        nguyenQuan: "Hà Nội",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Về hưu",
        diaChiHienTai: "Số 5 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nam",
        idcc: "000000000017"
    },
    {
        id: 18,
        hoTen: "Bùithị Hà",
        ngaySinh: "1948-02-02",
        nguyenQuan: "Hải Phòng",
        danToc: "Kinh",
        quocTich: "Việt Nam",
        ngheNghiep: "Nội trợ",
        diaChiHienTai: "Số 5 Tạ Quang Bưu, Hai Bà Trưng, Hà Nội",
        diaChiThuongTru: "Số 5 Tạ Quang Bửu, quận Hai Bà Trưng, Hà Nội",
        gioiTinh: "Nữ",
        idcc: "000000000018"
    }
]

const Person = () => {
    return (
        <div className="container">
            <table className="custom table table-bordered table-striped">
                <tr className="field">
                    <th>STT</th>
                    <th>Họ và tên</th>
                    <th>Giới tính</th>
                    <th>Ngày sinh</th>
                    <th>Số căn cước</th>
                    <th>Nguyên quán</th>
                    <th>Dân tộc</th>
                    <th>Quốc tịch</th>
                    <th>Nghề Nghiệp</th>
                    <th>Địa chỉ hiện tại</th>
                    <th>Địa chỉ thường trú</th>
                </tr>
                <tbody id="myTable">
                    {
                        personLists.map((person, index) => (
                            <tr className="data">
                                <td>{person.id}</td>
                                <td>{person.hoTen}</td>
                                <td>{person.gioiTinh}</td>
                                <td>{person.ngaySinh}</td>
                                <td>{person.idcc}</td>
                                <td>{person.nguyenQuan}</td>
                                <td>{person.danToc}</td>
                                <td>{person.quocTich}</td>
                                <td>{person.ngheNghiep}</td>
                                <td>{person.diaChiHienTai}</td>
                                <td>{person.diaChiThuongTru}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    )
}

export default Person