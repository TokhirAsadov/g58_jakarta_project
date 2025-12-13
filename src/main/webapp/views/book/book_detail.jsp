<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>${book.getTitle()} - Book Details</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Bootstrap Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">
    <style>
        .book-cover {
            max-height: 400px;
            object-fit: contain;
            border-radius: 10px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.1);
        }
        .book-details-card {
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            border-radius: 15px;
            border: none;
            box-shadow: 0 6px 20px rgba(0,0,0,0.1);
        }
        .detail-item {
            padding: 12px 0;
            border-bottom: 1px solid rgba(255,255,255,0.3);
        }
        .detail-item:last-child {
            border-bottom: none;
        }
        .info-badge {
            background-color: #6c757d;
            color: white;
            padding: 4px 12px;
            border-radius: 20px;
            font-size: 0.9em;
        }
        .pdf-container {
            border-radius: 10px;
            overflow: hidden;
            box-shadow: 0 5px 15px rgba(0,0,0,0.1);
        }
        .section-title {
            color: #2c3e50;
            font-weight: 600;
            border-left: 4px solid #3498db;
            padding-left: 15px;
            margin: 25px 0 15px 0;
        }
    </style>
</head>
<body>
<jsp:include page="/fragment/navbar.jsp"/>

<div class="container py-5">
    <!-- Breadcrumb Navigation -->
    <nav aria-label="breadcrumb" class="mb-4">
        <ol class="breadcrumb">
            <li class="breadcrumb-item"><a href="/book/list"><i class="bi bi-house-door"></i> Home</a></li>
            <li class="breadcrumb-item"><a href="/book/list">Books</a></li>
            <li class="breadcrumb-item active" aria-current="page">${book.getTitle()}</li>
        </ol>
    </nav>

    <div class="row g-4">
        <!-- Left Column - Book Details -->
        <div class="col-lg-4">
            <div class="card book-details-card h-100">
                <div class="card-body p-4">
                    <div class="text-center mb-4">
                        <div class="bg-light rounded-circle d-inline-flex align-items-center justify-content-center"
                             style="width: 120px; height: 120px;">
                            <i class="bi bi-book" style="font-size: 3rem; color: #3498db;"></i>
                        </div>
                        <h2 class="mt-3 mb-2">${book.getTitle()}</h2>
                        <span class="info-badge">
                            <i class="bi bi-tag"></i> Book ID: ${book.getId()}
                        </span>
                    </div>

                    <div class="mt-4">
                        <h5 class="section-title">Book Information</h5>
                        <div class="detail-item">
                            <div class="d-flex align-items-center">
                                <i class="bi bi-person-circle me-3" style="color: #3498db;"></i>
                                <div>
                                    <small class="text-muted d-block">Author</small>
                                    <strong>${book.getAuthor()}</strong>
                                </div>
                            </div>
                        </div>

                        <div class="detail-item">
                            <div class="d-flex align-items-center">
                                <i class="bi bi-file-text me-3" style="color: #3498db;"></i>
                                <div>
                                    <small class="text-muted d-block">Original File Name</small>
                                    <strong>${book.getFile().getOriginalName()}</strong>
                                </div>
                            </div>
                        </div>

                        <div class="detail-item">
                            <div class="d-flex align-items-center">
                                <i class="bi bi-hdd me-3" style="color: #3498db;"></i>
                                <div>
                                    <small class="text-muted d-block">File Size</small>
                                    <strong>
                                        <span class="text-primary">
                                            ${String.format("%.2f", book.getFile().getSize()/1024.0/1024.0)} MB
                                        </span>
                                    </strong>
                                </div>
                            </div>
                        </div>

                        <div class="detail-item">
                            <div class="d-flex align-items-center">
                                <i class="bi bi-calendar-date me-3" style="color: #3498db;"></i>
                                <div>
                                    <small class="text-muted d-block">Upload Date</small>
                                    <strong>Today</strong>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="mt-4">
                        <h5 class="section-title">Actions</h5>
                        <div class="d-grid gap-2">
                            <a href="/storage/download?fileID=${book.getFile().getId()}"
                               class="btn btn-primary">
                                <i class="bi bi-download me-2"></i>Download Book
                            </a>
                            <button class="btn btn-outline-secondary">
                                <i class="bi bi-share me-2"></i>Share
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Right Column - PDF Viewer and Description -->
        <div class="col-lg-8">
            <!-- PDF Viewer -->
            <div class="card mb-4 border-0 shadow">
                <div class="card-header bg-primary text-white d-flex justify-content-between align-items-center">
                    <h5 class="mb-0"><i class="bi bi-file-earmark-pdf me-2"></i>Book Preview</h5>
                    <div>
                        <span class="badge bg-light text-dark">
                            <i class="bi bi-zoom-in me-1"></i> Scroll to navigate
                        </span>
                    </div>
                </div>
                <div class="card-body p-0 pdf-container">
                    <iframe
                            src="/storage/show?filename=${book.getFile().getPreparedName()}"
                            width="100%"
                            height="600px"
                            style="border: none;"
                            title="Book Preview">
                    </iframe>
                </div>
                <div class="card-footer bg-light">
                    <div class="row text-center">
                        <div class="col">
                            <small class="text-muted">
                                <i class="bi bi-arrow-left-right"></i> Use mouse wheel to scroll
                            </small>
                        </div>
                        <div class="col">
                            <small class="text-muted">
                                <i class="bi bi-zoom-in"></i> Ctrl + Scroll to zoom
                            </small>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Description Section -->
            <div class="card border-0 shadow">
                <div class="card-header bg-white">
                    <h5 class="mb-0"><i class="bi bi-card-text me-2"></i>Description</h5>
                </div>
                <div class="card-body">
                    <div class="p-3 bg-light rounded">
                        <p class="mb-0">
                            ${not empty book.getDescription() ? book.getDescription() : 'No description available for this book.'}
                        </p>
                    </div>
                </div>
            </div>

            <!-- Additional Info -->
            <div class="row mt-4">
                <div class="col-md-6">
                    <div class="card border-0 shadow-sm h-100">
                        <div class="card-body">
                            <h6><i class="bi bi-info-circle me-2"></i>Reading Tips</h6>
                            <ul class="list-unstyled small">
                                <li class="mb-2"><i class="bi bi-check-circle text-success me-2"></i>Use fullscreen for better reading</li>
                                <li class="mb-2"><i class="bi bi-check-circle text-success me-2"></i>Download for offline reading</li>
                                <li><i class="bi bi-check-circle text-success me-2"></i>Adjust zoom for comfortable reading</li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="col-md-6">
                    <div class="card border-0 shadow-sm h-100">
                        <div class="card-body">
                            <h6><i class="bi bi-clock me-2"></i>Quick Stats</h6>
                            <div class="row text-center">
                                <div class="col-4">
                                    <div class="display-6 text-primary">${book.getId()}</div>
                                    <small class="text-muted">Book ID</small>
                                </div>
                                <div class="col-4">
                                    <div class="display-6 text-success">
                                        ${String.format("%.2f", book.getFile().getSize()/1024.0/1024.0)}
                                    </div>
                                    <small class="text-muted">Size (MB)</small>
                                </div>
                                <div class="col-4">
                                    <div class="display-6 text-warning">1</div>
                                    <small class="text-muted">Version</small>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS Bundle -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>