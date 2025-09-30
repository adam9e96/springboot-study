// 현재 연도
const now = new Date();
const thisYear = now.getFullYear();

const yearSelect = document.getElementById("birth_year");
const monthSelect = document.getElementById("birth_month");
const daySelect = document.getElementById("birth_day");

// 연도 옵션 추가 (1900 ~ 올해)
for (let y = 1900; y <= thisYear; y++) {
    let option = document.createElement("option");
    option.value = y;
    option.text = y + "년";
    yearSelect.add(option);
}

// 월 옵션 추가 (1 ~ 12)
for (let m = 1; m <= 12; m++) {
    let option = document.createElement("option");
    option.value = m;
    option.text = m + "월";
    monthSelect.add(option);
}

// 일 옵션 추가 (1 ~ 31)
for (let d = 1; d <= 31; d++) {
    let option = document.createElement("option");
    option.value = d;
    option.text = d + "일";
    daySelect.add(option);
}