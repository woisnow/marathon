package mesosphere.marathon.core.task.update.impl.steps

import com.google.inject.Inject
import mesosphere.marathon.Protos.MarathonTask
import mesosphere.marathon.core.task.tracker.TaskUpdater
import mesosphere.marathon.core.task.update.TaskStatusUpdateStep
import mesosphere.marathon.state.{ PathId, Timestamp }
import org.apache.mesos.Protos.TaskStatus

import scala.concurrent.Future

/**
  * Update task tracker corresponding to the event.
  */
class UpdateTaskTrackerStepImpl @Inject() (taskUpdater: TaskUpdater) extends TaskStatusUpdateStep {

  def name: String = "updateTaskTracker"

  def processUpdate(
    timestamp: Timestamp, appId: PathId, task: MarathonTask, status: TaskStatus): Future[_] = {

    taskUpdater.statusUpdate(appId, status)
  }
}
