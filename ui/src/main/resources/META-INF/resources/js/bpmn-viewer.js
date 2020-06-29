var diagramUrl = 'bpmn/requests.bpmn2';

// viewer instance
var bpmnViewer = new BpmnJS({
    container: '#canvas',
    overlays: {
        defaults: {
          show: { minZoom: 1 },
          scale: true
        }
      }
});

var overlays = bpmnViewer.get('overlays');

function processState(state){
    var overlays = bpmnViewer.get('overlays');
    
    var overlayHtml = $('<div>Mixed up the labels?</div>');

    overlayHtml.click(function(e) {
        alert('someone clicked me');
    });

    // attach the overlayHtml to a node
    overlays.add('SCAN_OK', {
    position: {
        bottom: 0,
        right: 0
    },
    html: overlayHtml
    });
}
/**
 * Open diagram in our viewer instance.
 *
 * @param {String} bpmnXML diagram to display
 */
async function openDiagram(bpmnXML) {
    // import diagram
    try {
        await bpmnViewer.importXML(bpmnXML);
        // access viewer components
        var canvas = bpmnViewer.get('canvas');
        var overlays = bpmnViewer.get('overlays');

        // zoom to fit full viewport
        canvas.zoom('fit-viewport');
        console.log(overlays);
        // attach an overlay to a node
        
        /*
        overlays.add('START_PROCESS', 'note', {
        position: {
            bottom: 0,
            right: 0
        },
        html: '<div class="diagram-note">Mixed up the labels?</div>'
        });*/

        // add marker
        //canvas.addMarker('SCAN_OK', 'needs-discussion');
    } catch (err) {

        console.error('could not import BPMN 2.0 diagram', err);
    }
}