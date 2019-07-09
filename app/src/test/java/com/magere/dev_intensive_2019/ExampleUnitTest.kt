package com.magere.dev_intensive_2019

import com.magere.dev_intensive_2019.extensions.TimeUnits
import com.magere.dev_intensive_2019.extensions.add
import com.magere.dev_intensive_2019.extensions.format
import com.magere.dev_intensive_2019.extensions.stripHtml
import com.magere.dev_intensive_2019.models.User
import com.magere.dev_intensive_2019.utils.Utils
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_user(){
        val user = User.makeUser("ll")
        print("${user.firstName} ${user.lastName}")
    }

    @Test
    fun test_DateFormat(){
        print(Date().format())
        print(Date().add(-2, TimeUnits.DAY).format())
    }


    //TODO
    @Test
    fun test_string_html(){
//        print("             <p> Mama       A papa ne dishit</p   >         ".stripHtml().trim())
        print(Regex("""(<\w*>)""").replace("<[ 4fjaf]>ff", ""))
    }

    @Test
    fun toInit(){
        print(Utils.toInitials(null, null))
    }
}
