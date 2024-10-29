package com.example.searchlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var studentAdapter: StudentAdapter
    private lateinit var studentList: MutableList<Student>
    private lateinit var recyclerView: RecyclerView
    private lateinit var searchEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        searchEditText = findViewById(R.id.searchEditText)

        studentList = mutableListOf(
            Student("Nguyễn Văn An", "20210345"),
            Student("Trần Thị Bích", "20210123"),
            Student("Lê Văn Cường", "20211234"),
            Student("Hoàng Thị Dung", "20211456"),
            Student("Phạm Minh Đức", "20210098"),
            Student("Vũ Thị Hạnh", "20210987"),
            Student("Đỗ Thanh Hòa", "20210654"),
            Student("Trương Quang Hiếu", "20210432"),
            Student("Bùi Thị Lan", "20211112"),
            Student("Nguyễn Thị Hương", "20211876"),
            Student("Lê Quốc Khánh", "20211357"),
            Student("Nguyễn Văn Long", "20210234"),
            Student("Phạm Hoàng Minh", "20220789"),
            Student("Trần Thị Ngọc", "20220345"),
            Student("Đặng Văn Nam", "20221012"),
            Student("Lê Khánh Nguyên", "20221456"),
            Student("Hoàng Nhật Quang", "20220876"),
            Student("Nguyễn Minh Quý", "20221234"),
            Student("Đỗ Thanh Sang", "20221987"),
            Student("Bùi Tấn Tài", "20220543"),
            Student("Trần Thị Uyên", "20221321"),
            Student("Nguyễn Bảo Vinh", "20230876"),
            Student("Lê Hoàng Khôi", "20230234"),
            Student("Vũ Văn Duy", "20231876"),
            Student("Phạm Gia Hưng", "20231001"),
            Student("Đặng Thị Yến", "20230987"),
            Student("Trần Minh Tuấn", "20231765"),
            Student("Nguyễn Khánh Vân", "20232012"),
            Student("Đỗ Văn Khoa", "20232543"),
            Student("Phạm Thị Mai", "20240123"),
            Student("Nguyễn Văn Tùng", "20240321"),
            Student("Lê Quang Phát", "20241234"),
            Student("Trương Mỹ Linh", "20241876"),
            Student("Vũ Anh Tuấn", "20241198"),
            Student("Phạm Văn Bình", "20240456"),
            Student("Nguyễn Hoàng Phúc", "20242211")
        )




        // Khởi tạo adapter và thiết lập cho RecyclerView
        studentAdapter = StudentAdapter(studentList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = studentAdapter

        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

            override fun afterTextChanged(s: Editable?) {
                val keyword = s.toString().trim() // Lấy từ khóa và xóa khoảng trắng
                val filteredList = if (keyword.length > 2) {
                    studentList.filter {
                        it.name.contains(keyword, ignoreCase = true) || it.mssv.contains(keyword)
                    }
                } else {
                    studentList // Nếu từ khóa ngắn hơn hoặc bằng 2, trả về danh sách đầy đủ
                }
                studentAdapter.updateList(filteredList)
            }
        })

    }
        }
