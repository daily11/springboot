package com.swust.springboot.dao;


import com.swust.springboot.entity.BookDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BookDao {

    /**
     * 查询书记录
     *
     * @param name 书名
     * @return
     */
    BookDO selectByName(@Param("bookName") String name);

    /**
     * 查询书记录
     *
     * @param id 书ID
     * @return
     */
    BookDO selectById(@Param("bookId") Long id);

    /**
     * 删除书记录
     *
     * @param id
     * @return
     */
    Integer deleteById(@Param("bookId") Long id);

    /**
     * 插入书记录
     *
     * @param book 书对象
     * @return
     */
    Integer insert(BookDO book);

    /**
     * 更新书记录
     *
     * @param book 书对象
     * @return
     */
    Integer update(BookDO book);

}

