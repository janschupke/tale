<?php

session_start();

error_reporting(E_PARSE | E_WARNING);
// error_reporting(E_ALL);

require_once('vendor/phpmailer/class.phpmailer.php');

$questions = array(
    "Is talkative",
    "Tends to find fault with others",
    "Does a thorough job",
    "Is depressed, blue",
    "Is original, comes up with new ideas",
    "Is reserved",
    "Is helpful and unselfish with others",
    "Can be somewhat careless",
    "Is relaxed, handles stress well",
    "Is curious about many different things",
    "Is full of energy",
    "Starts quarrels with others",
    "Is a reliable worker",
    "Can be tense",
    "Is ingenious, a deep thinker",
    "Generates a lot of enthusiasm",
    "Has a forgiving nature",
    "Tends to be disorganized",
    "Worries a lot",
    "Has an active imagination",
    "Tends to be quiet",
    "Is generally trusting",
    "Tends to be lazy",
    "Is emotionally stable, not easily upset",
    "Is inventive",
    "Has an assertive personality",
    "Can be cold and aloof",
    "Perseveres until the task is finished",
    "Can be moody",
    "Values artistic, aesthetic experiences",
    "Is sometimes shy, inhibited",
    "Is considerate and kind to almost everyone",
    "Does things efficiently",
    "Remains calm in tense situations",
    "Prefers work that is routine",
    "Is outgoing, sociable",
    "Is sometimes rude to others",
    "Makes plans and follows through with them",
    "Gets nervous easily",
    "Likes to reflect, play with ideas",
    "Has few artistic interests",
    "Likes to cooperate with others",
    "Is easily distracted",
    "Is sophisticated in art, music, or literature"
);

$errors = array();

function handleFileUpload() {
    global $errors;

    try {
        // Undefined | Multiple Files | $_FILES Corruption Attack
        // If this request falls under any of them, treat it invalid.
        if (
            !isset($_FILES['dataFolder']['error']) ||
            is_array($_FILES['dataFolder']['error'])
        ) {
            array_push($errors, "Invalid file parameters.");
            return false;
        }

        // Check $_FILES['dataFolder']['error'] value.
        switch ($_FILES['dataFolder']['error']) {
            case UPLOAD_ERR_OK:
                break;
            case UPLOAD_ERR_NO_FILE:
                throw new RuntimeException('No date file was submitted sent.');
                return false;
            case UPLOAD_ERR_INI_SIZE:
            case UPLOAD_ERR_FORM_SIZE:
                array_push($errors, 'Exceeded filesize limit.');
                return false;
            default:
                array_push($errors, 'Unknown errors during file upload.');
                return false;
        }

        // You should also check filesize here.
        if ($_FILES['dataFolder']['size'] > 1500000) {
            array_push($errors, 'Exceeded filesize limit.');
            return false;
        }

        return true;

    } catch (RuntimeException $e) {
        array_push($errors, $e->getMessage());
        return false;
    }
}

function checkQuestionnaire() {
    global $errors;
    global $questions;

    $i = 0;
    foreach ($questions as $key => $value) {
        if (empty($_POST['formQuestion'][$i])) {
            array_push($errors, 'Some questions were not answered.');
            return false;
        }

        $i++;
    }

    return true;
}

function sendData() {
    global $errors;
    global $questions;

    $message = "<p>";
    $i = 0;
    foreach ($questions as $key => $value) {
        $message .= 'Q' . ($i + 1) . ';' . $value . ';A' . $_POST['formQuestion'][$i] . '<br />';
        $i++;
    }
    $message .= '</p>';

    $email = new PHPMailer();
    $email->IsHTML(true);
    $email->From      = 'tale@janschupke.eu';
    $email->Subject   = '[Tale] Game Log';
    $email->Body      = $message;
    $email->AddAddress('jan.schupke@gmail.com');
    $email->AddAttachment($_FILES['dataFolder']['tmp_name'], $_FILES['dataFolder']['name']);

    return $email->Send();
}

if (!empty($_POST)) {
    $passed = true;

    if (!checkQuestionnaire()) {
        $passed = false;
    }

    if ($passed) {
        if (!handleFileUpload()) {
            $passed = false;
        }
    }

    if ($passed) {
        if (sendData()) {
            $_SESSION["success"] = 'success';
            header("location: " . $_SERVER['SCRIPT_NAME']);
            die();
        }
    }
}
?>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta charset="UTF-8" />
    <title>Tale</title>
    <link rel="icon" type="image/png" href="images/favicon.png" />
    <link rel="stylesheet" type="text/css" href="css/main.css" />
    <script src="vendor/jquery.js"></script>

    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.css" />
    <script src="vendor/bootstrap/js/bootstrap.js"></script>

    <link href="vendor/lightbox/dist/css/lightbox.css" rel="stylesheet" />

    <link rel="stylesheet" type="text/css" href="vendor/font-awesome/css/font-awesome.css" />
</head>
<body>

<div class="container">

<?php
if ($_SESSION["success"] == 'success') {
    unset($_SESSION["success"]);
    echo '<div class="alert alert-success">Your submission has been accepted. Thanks for participating.</div>';
} else {
    foreach ($errors as $key => $value) {
        echo '<div class="alert alert-danger">' . $value . '</div>';
    }
}
?>

<h1>Tale</h1>
<div class="row">
    <div class="col-md-8">
<p>Tale is a short roleplaying game intended to collect data that are relevant for player's personality modelling. This page provides an interface for testers to upload their data for the upcoming data analysis.</p>
<p>What's asked of you:</p>
<ol>
    <li>Download and play the game.</li>
    <li>Provide generated game logs.</li>
    <li>Fill in and submit the questionnaire on this page.</li>
    <li>Share this page with anyone who might be interested in playing.</li>
</ol>
    </div>
    <div class="col-md-4 hidden-sm hidden-xs">
        <div class="pull-right">
            <img src="images/caravan.png" />
        </div>
    </div>
</div>

<h2>Download</h2>
<div class="row">
    <div class="col-md-3 hidden-sm hidden-xs">
        <img src="images/crossroads.png" />
    </div>
    <div class="col-md-9">
        <p>Java 8 is required for the application to run. It can be downloaded from
        <a href="https://java.com/en/download/" target="_blank">java.com/en/download<sup><i class="fa fa-external-link"></i></sup></a>.</p>
        <ul>
            <li><a href="https://bitbucket.org/Vehicless/tale/downloads/tale.exe"><i class="fa fa-windows"></i> Download Tale for Windows</a></li>
            <li><a href="https://bitbucket.org/Vehicless/tale/downloads/tale.jar"><i class="fa fa-linux"></i> Download Tale as a .jar file</a></li>
        </ul>

        <p>A couple of points:</p>
        <ul>
            <li>Playthrough takes around 15 minutes.</li>
            <li>Every action in the game is optional. Content may be skipped.</li>
            <li>While there is a defined ending, it is not necessary to reach it.</li>
            <li>Game may be played multiple times.</li>
            <li>Make sure you exit the application before uploading the data folder.</li>
            <li>It is important to upload the entire 'tale' folder as an <b>archive (zip/rar/tar)</b>.</li>
        </ul>
    </div>
</div>
<form enctype="multipart/form-data" id="questionnaireForm" method="post" action="<?php echo $_SERVER['SCRIPT_NAME'] ?>" class="form">
    <div class="form-group">
        <h2>Upload your data folder</h2>
    </div>
    <div class="form-group errorMessage dataError">
        <div class="col-xs-12 text-danger">
            Please provide the data folder:
        </div>
    </div>
    <div class="form-group">
        <!-- <label for="dataFolder">Upload your data folder:</label> -->
        <input type="file" id="dataFolder" name="dataFolder" />
        <p class="help-block">Tale data folder will be located in your home directory after finishing the game. Its location is mentioned in the game's main menu. <a href="images/data-location.png" data-lightbox="folder" data-title="Game log data folder">[How to find data folder]</a></p>
    </div>

    <div class="form-group">
        <h2>Questionnaire</h2>
    </div>
    <div class="form-group">
        <table class="table table-hover table-striped">
            <tr>
                <th colspan="2">I am someone who:</th>
                <th style="width:10%;">Strongly Disagree</th>
                <th style="width:10%;">Disagree</th>
                <th style="width:10%;">Neutral</th>
                <th style="width:10%;">Agree</th>
                <th style="width:10%;">Strongly Agree</th>
            </tr>
            <?php
                $j = 0;
                foreach ($questions as $key => $value) {
                    echo '<tr class="errorMessage formQuestion'. $j .'Error">';
                    echo '<td colspan="7" class="text-danger ">';
                    echo 'Please pick an option:';
                    echo '</td>';
                    echo '</tr>';

                    echo '<tr>';
                    echo '<td>';
                    echo ($j + 1 < 10) ? "0" . ($j + 1) : ($j + 1);
                    echo '</td>';
                    echo '<td>';
                    echo $value;
                    echo '</td>';
                    for ($i = 1; $i <=5; $i++) {
                        echo '<td>';
                        if ($_POST['formQuestion'][$j] == $i) {
                            $selected = 'checked="checked"';
                        } else {
                            $selected = '';
                        }
                        echo '<input type="radio" id="formQuestion[' . $j . '][' . $i . ']" ';
                        echo 'name="formQuestion[' . $j . ']" value="' . $i . '" '. $selected .' />';
                        echo '</td>';
                    }
                    echo '</tr>';

                    $j++;
                }
            ?>
        </table>
    </div>

    <div class="form-group errorMessage errorNotification">
        <div class="col-xs-12 text-danger">
            Please check the form again. Some inputs are filled in incorrectly.
        </div>
    </div>

    <div class="form-group">
        <div class="col-xs-12">
            <div class="pull-right">
                <button type="submit" name="submit" class="btn btn-primary">Submit your answers</button>
            </div>
        </div>
    </div>
</form>

<h2>References</h2>

<div class="row">
    <div class="col-md-3 hidden-sm hidden-xs">
        <img src="images/road-sign.png" />
    </div>
    <div class="col-md-9">
        <p>John, O. P., Donahue, E. M., &amp; Kentle, R. L. (1991). The Big Five Inventory - Versions 4a and 54. Berkeley, CA: University of California, Berkeley, Institute of Personality and Social Research.</p>
        <p>John, O. P., Naumann, L. P., &amp; Soto, C. J. (2008). Paradigm shift to the integrative Big Five trait taxonomy: History, measurement, and conceptual issues. In O. P. John, R. W. Robins, &amp; L. A. Pervin (Eds.), Handbook of personality: Theory and research (pp. 114-158). New York, NY: Guilford Press.</p>
    </div>
</div>

<div class="row footer">
    <div class="col-xs-12"></div>
</div>

</div>

<script type="text/javascript">
//<![CDATA[

function validateEmail(email) {
    var re = /\S+@\S+\.\S+/;
    return re.test(email);
}

$(document).on('submit','#questionnaireForm',function(e) {
    var passed = true;

    if ($('#dataFolder').val().length === 0) {
        $('.dataError').fadeIn();
        passed = false;
    } else {
        $('.dataError').fadeOut();
    }

    <?php
    $j = 0;
    foreach ($questions as $key => $value) {
    ?>
        if (!$("input:radio[name='<?php echo 'formQuestion[' . $j . ']'; ?>']").is(":checked")) {
            $('.<?php echo 'formQuestion' . $j . 'Error'; ?>').fadeIn();
            passed = false;
        } else {
            $('.<?php echo 'formQuestion' . $j . 'Error'; ?>').fadeOut();
        }
    <?php
    $j++;
    }
    ?>

    if (!passed) {
        $('.errorNotification').fadeIn();
    } else {
        $('.errorNotification').fadeOut();
    }

    if (!passed) {
        return false;
    }

    return true;
});

//]]>
</script>

<script src="vendor/lightbox/dist/js/lightbox.js"></script>
</body>
</html>
