package qna.repository.entity;

import qna.domain.ContentType;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "delete_history")
public class DeleteHistory {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(value = EnumType.STRING)
    private ContentType contentType;
    @Column(name = "content_id")
    private Long contentId;
    @Column(name = "delete_by_id")
    private Long deletedById;
    @Column(name = "create_date")
    private LocalDateTime createDate = LocalDateTime.now();

    public DeleteHistory(ContentType contentType, Long contentId, Long deletedById, LocalDateTime createDate) {
        this.contentType = contentType;
        this.contentId = contentId;
        this.deletedById = deletedById;
        this.createDate = createDate;
    }

    protected DeleteHistory() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DeleteHistory that = (DeleteHistory) o;
        return Objects.equals(id, that.id) &&
                contentType == that.contentType &&
                Objects.equals(contentId, that.contentId) &&
                Objects.equals(deletedById, that.deletedById);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contentType, contentId, deletedById);
    }

    @Override
    public String toString() {
        return "DeleteHistory{" +
                "id=" + id +
                ", contentType=" + contentType +
                ", contentId=" + contentId +
                ", deletedById=" + deletedById +
                ", createDate=" + createDate +
                '}';
    }
}