abstract class Event: Attachment {
    override val type = "event"
    abstract val eventDetails: EventDetails
}