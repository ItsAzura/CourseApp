package com.example.courseapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.courseapplication.ui.theme.CourseApplicationTheme
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseApplicationTheme {
                CourseApp()
            }
        }
    }
}

@Composable
fun CourseApp(){
    CourseList(courseList = Database().loadCourse())
}

@Composable
fun CourseCard(course: Course,modifier: Modifier = Modifier){
        Card(modifier = modifier
            .width(180.dp)
            .height(100.dp)
            .shadow(
                elevation = 8.dp,
                shape = RoundedCornerShape(8.dp)
            )
        ) {
            Row(modifier = Modifier
                .clip(RoundedCornerShape(20.dp))
            ) {
                Image(painter = painterResource(id = course.pic),
                    contentDescription = stringResource(id = course.title),
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.37f),
                    contentScale = ContentScale.Crop
                )
                Column(modifier = Modifier
                    .padding(
                        start = 8.dp
                    )
                ) {
                    Text(
                        text = LocalContext.current.getString(course.title),
                        modifier = Modifier.padding(
                            top = 16.dp,
                            end = 8.dp,
                            bottom = 8.dp
                        ),
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        style = TextStyle(
                            lineHeight = 30.sp,
                        )
                    )
                    Row() {
                        Image(painter = painterResource(id = R.drawable.ic_member_foreground),
                            contentDescription = "",
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(50.dp)
                                .padding(
                                    end = 8.dp
                                )
                        )
                        Text(text = course.member.toString(),
                            fontSize = 14.sp,
                            modifier = Modifier
                                .padding(
                                    top = 18.dp,
                                )
                        )
                    }
                }

            }
        }
}

@Composable
fun CourseList(courseList: List<Course>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        itemsIndexed(courseList) { index, course ->
            if (index % 2 == 0) {
                Row {
                    CourseCard(
                        course = course,
                        modifier = Modifier.padding(4.dp)
                    )

                    Spacer(modifier = Modifier.width(4.dp))

                    courseList.getOrNull(index + 1)?.let {
                        CourseCard(
                            course = it,
                            modifier = Modifier.padding(4.dp)
                        )
                    }
                }
            }
        }
    }
}


