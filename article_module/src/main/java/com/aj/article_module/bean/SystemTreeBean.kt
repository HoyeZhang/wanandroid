package com.aj.article_module.bean

import android.os.Parcel
import android.os.Parcelable

/**
 *
 * @Package:        com.aj.article_module.bean
 * @ClassName:      SystemTreeBean
 * @Description:
 * @Author:         zhy
 * @CreateDate:     2020/8/19 10:17
 */
data class SystemTreeBean(
    val children: List<SystemTreeChildren>,
    val courseId: Int,
    val id: Int,
    val name: String?,
    val order: Int,
    val parentChapterId: Int,
    val visible: Int
) : Parcelable {
    constructor(source: Parcel) : this(
        ArrayList<SystemTreeChildren>().apply { source.readList(this as List<*>, SystemTreeChildren::class.java.classLoader) },
        source.readInt(),
        source.readInt(),
        source.readString(),
        source.readInt(),
        source.readInt(),
        source.readInt()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeList(children)
        writeInt(courseId)
        writeInt(id)
        writeString(name)
        writeInt(order)
        writeInt(parentChapterId)
        writeInt(visible)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<SystemTreeBean> =
            object : Parcelable.Creator<SystemTreeBean> {
                override fun createFromParcel(source: Parcel): SystemTreeBean =
                    SystemTreeBean(source)

                override fun newArray(size: Int): Array<SystemTreeBean?> = arrayOfNulls(size)
            }
    }
}

