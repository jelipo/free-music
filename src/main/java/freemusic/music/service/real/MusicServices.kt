package freemusic.music.service.real

import freemusic.music.pojo.SearchParams
import java.util.ArrayList

interface MusicServices{
    fun getFormatJson(mainFormPojo: SearchParams): ArrayList<*>

    fun getSearchResult(mainFormPojo: SearchParams): String
}