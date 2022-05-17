-- phpMyAdmin SQL Dump
-- version 4.6.6deb5ubuntu0.5
-- https://www.phpmyadmin.net/
--
-- Máy chủ: localhost:3306
-- Thời gian đã tạo: Th5 08, 2022 lúc 01:16 AM
-- Phiên bản máy phục vụ: 5.7.38-0ubuntu0.18.04.1
-- Phiên bản PHP: 7.2.34-28+ubuntu18.04.1+deb.sury.org+1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `rfid_stu`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `in_out`
--

CREATE TABLE `in_out` (
  `ID` int(11) NOT NULL,
  `ID_STU` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `TIME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `STATUS` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `student`
--

CREATE TABLE `student` (
  `ID` varchar(20) COLLATE utf8_unicode_ci NOT NULL,
  `EPC` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `NAME` varchar(100) COLLATE utf8_unicode_ci NOT NULL,
  `BIRTHDAY` varchar(10) COLLATE utf8_unicode_ci NOT NULL,
  `SEX` tinyint(1) NOT NULL,
  `CLASS` varchar(10) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Đang đổ dữ liệu cho bảng `student`
--

INSERT INTO `student` (`ID`, `EPC`, `NAME`, `BIRTHDAY`, `SEX`, `CLASS`) VALUES
('SV001', '4D415400', 'Phạm Nguyễn Minh Thuận', '2001-01-28', 1, 'DKP');

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `in_out`
--
ALTER TABLE `in_out`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `ID_STU` (`ID_STU`);

--
-- Chỉ mục cho bảng `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `in_out`
--
ALTER TABLE `in_out`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `in_out`
--
ALTER TABLE `in_out`
  ADD CONSTRAINT `in_out_ibfk_1` FOREIGN KEY (`ID_STU`) REFERENCES `student` (`ID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
