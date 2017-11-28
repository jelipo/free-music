package freemusic.music.service.real

import freemusic.music.pojo.MainFormPojo
import java.util.ArrayList

interface MusicServices{
    fun getFormatJson(mainFormPojo: MainFormPojo): ArrayList<*>

    fun getSearchResult(mainFormPojo: MainFormPojo): String
}